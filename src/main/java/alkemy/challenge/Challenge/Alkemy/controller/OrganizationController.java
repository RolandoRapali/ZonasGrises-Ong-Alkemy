package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDto;
import alkemy.challenge.Challenge.Alkemy.converter.OrganizationDtoConverter;
import alkemy.challenge.Challenge.Alkemy.model.Organization;
import alkemy.challenge.Challenge.Alkemy.service.OrganizationService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    private final OrganizationDtoConverter organizationDtoConverter;


    @GetMapping("/public")
    public OrganizationDto bringOrganization(@RequestParam(name = "id", defaultValue = "1") Long id) {
        return organizationDtoConverter.convertEntityToGetOrganizationDto(organizationService.bringOrganization(id));
    }

    @PostMapping("/public")
    public ResponseEntity<?> modifyOrganization(@RequestBody @Valid OrganizationDto organizationDto) {
        if (organizationDto.getName().isEmpty() || organizationDto.getName().isBlank()) {
            return new ResponseEntity(new Message("el campo de nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (organizationDto.getImage().isEmpty() || organizationDto.getImage().isBlank()) {
            return new ResponseEntity(new Message("el campo de imagen no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (organizationDto.getLinkdnUrl().isEmpty() || organizationDto.getLinkdnUrl().isBlank()) {
            return new ResponseEntity(new Message("el campo de la url linkedn no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (organizationDto.getFacebookUrl().isEmpty() || organizationDto.getFacebookUrl().isBlank()) {
            return new ResponseEntity(new Message("el campo de la url de facebook no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (organizationDto.getInstagramUrl().isEmpty() || organizationDto.getInstagramUrl().isBlank()) {
            return new ResponseEntity(new Message("el campo de la url de instagram no puede estar vacio"), HttpStatus.BAD_REQUEST);
        } else {
            organizationService.update(organizationDto);
            return new ResponseEntity(new Message("la organizacion ha sido modificada con exito."), HttpStatus.OK);
        }
    }
}
