package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDto;
import alkemy.challenge.Challenge.Alkemy.model.Organization;
import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization bringOrganization(Long id) {
        return organizationRepository.findById(id).get();
    }

    public void update(OrganizationDto organizationDto) {

    }

    public ResponseEntity<?> updateOrganization(OrganizationDto organizationDto) {
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
        }
        Organization organization = organizationRepository.findById(1L).get();
        organization.setName(organizationDto.getName());
        organization.setImage(organizationDto.getImage());
        if(organizationDto.getAdress().isBlank())organization.setAddress(organizationDto.getAdress());
        if(organizationDto.getPhone() > 0)organization.setPhone(organizationDto.getPhone());
        if(organizationDto.getLinkdnUrl().isBlank()) organization.setLinkdnUrl(organizationDto.getLinkdnUrl());
        if(organizationDto.getFacebookUrl().isBlank()) organization.setFacebookUrl(organizationDto.getFacebookUrl());
        if(organizationDto.getInstagramUrl().isBlank()) organization.setInstagramUrl(organizationDto.getInstagramUrl());
        organizationRepository.save(organization);
        return new ResponseEntity(new Message("la organizacion ha sido modificada con exito."), HttpStatus.OK);
    }
}
