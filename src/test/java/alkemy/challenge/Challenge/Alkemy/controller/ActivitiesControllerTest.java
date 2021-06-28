package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.service.ActivityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations= "classpath:test.properties")
public class ActivitiesControllerTest {
     
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActivityService service;

    @Autowired
    ObjectMapper objectMapper;
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
    
    @Test
    @WithMockUser(username = "admin@alkemy.com")
    public void listActivitiesTest() throws Exception {
        List<Activity> listActivity = new ArrayList<>();

        listActivity.add(new Activity(5L,"nombre5",
                "contenido5",
                "imagen5",
                false,
                null,
                null));
        listActivity.add(new Activity(4L,"nombre4",
                "contenido4",
                "imagen4",
                false,
                null,
                null));

        Mockito.when(service.findAll()).thenReturn(listActivity);
        String url = "/activities";

        RequestBuilder request = get(url);
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());
       
    }
   
    @Test
    @WithMockUser(username = "admin@alkemy.com", roles = {"ADMIN"})
    public void createActivitiesTest() throws Exception {
        Activity activity = new Activity("nombre3","contenido3","imagen3");
        String jsonRequest = objectMapper.writeValueAsString(activity);
        MvcResult result = mockMvc
                .perform(post("/activities").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
    
    @Test
    @WithMockUser(username = "admin@alkemy.com", roles = {"ADMIN"})
    public void getActivitiesByID() throws Exception {
        Activity activity = new Activity(1L,
                "nombreX",
                "contenidoX",
                "ImagenX",
                false,
                null,
                null);
        given(service.getActivitiesByID(activity.getId()))
                .willReturn(java.util.Optional.of(activity));

        this.mockMvc
                .perform(get("/activities" + "/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }
}
