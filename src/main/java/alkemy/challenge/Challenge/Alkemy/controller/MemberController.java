package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import alkemy.challenge.Challenge.Alkemy.repository.MemberRepository;
import alkemy.challenge.Challenge.Alkemy.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping
    public ResponseEntity<?> newMember(@Valid @RequestBody Member member, BindingResult result){

        Map<String, Object> response = new HashMap<>();
        errorHandlingService.registerErrorHandling(result, response);

        try{
            memberRepository.save(member);
        }catch (Exception e){
            response.put("message", "ERROR DB");
            response.put("error_member", e.getMessage().concat(":"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("member",member);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


}
