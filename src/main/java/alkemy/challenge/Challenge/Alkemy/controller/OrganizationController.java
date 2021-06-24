package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.converter.OrganizationDtoConverter;
import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDto;
import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.service.OrganizationService;
import alkemy.challenge.Challenge.Alkemy.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationDtoConverter organizationDtoConverter;

    @Autowired
    private SlideService slideService;

    @GetMapping("/public")
    public OrganizationDto bringOrganization(@RequestParam(name = "id", defaultValue = "1") Long id) {
        return organizationDtoConverter.convertEntityToGetOrganizationDto(organizationService.bringOrganization(id));
    }

    @PutMapping("/public")
    public ResponseEntity<?> modifyOrganization(@RequestBody @Valid OrganizationDto organizationDto) {
        return organizationService.update(organizationDto);
    }

    @GetMapping("/{id}/slides")
    public List<Slide> listOrganizationSlides(@PathVariable Long id) {
        return slideService.findSlidesByOrganization(id);
    }
}
