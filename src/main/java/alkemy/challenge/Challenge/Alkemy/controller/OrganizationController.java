package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDto;
import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDtoConverter;
import alkemy.challenge.Challenge.Alkemy.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    private final OrganizationDtoConverter organizationDtoConverter;

    @GetMapping("/public")
    public OrganizationDto bringOrganization(@RequestParam(name = "id", defaultValue = "1") int id) {
        return organizationDtoConverter.convertEntityToGetOrganizationDto(organizationService.bringOrganization(id));
    }

    @PostMapping("/public")
    public void modifyOrganization(@RequestBody OrganizationDto organizationDto) {
        organizationService.update(organizationDto);
    }


}
