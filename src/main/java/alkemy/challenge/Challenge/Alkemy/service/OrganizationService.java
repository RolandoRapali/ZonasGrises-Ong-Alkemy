package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.OrganizationDto;
import alkemy.challenge.Challenge.Alkemy.model.Organization;
import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public Organization bringOrganization(int id) {
        return organizationRepository.getById((long) id);
    }

    public void update(OrganizationDto organizationDto) {
        Organization organization = bringOrganization(1);
        organization.setName(organizationDto.getName());
        organization.setImage(organizationDto.getImage());
        if (organizationDto.getAdress() != null) {
            organization.setAddress(organizationDto.getAdress());
        }
        if (organizationDto.getPhone() != 0) {
            organization.setPhone(organizationDto.getPhone());
        }
        organizationRepository.save(organization);
    }
}
