package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDto;
import alkemy.challenge.Challenge.Alkemy.model.Organization;
import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization bringOrganization(Long id) {
        return organizationRepository.getById((long) id);
    }

    public void update(OrganizationDto organizationDto) {
        Organization organization = bringOrganization(1L);
        organization.setName(organizationDto.getName());
        organization.setImage(organizationDto.getImage());
        if(organizationDto.getAdress() != null)organization.setAddress(organizationDto.getAdress());
        if(organizationDto.getPhone() != 0)organization.setPhone(organizationDto.getPhone());
        organizationRepository.save(organization);
    }
}
