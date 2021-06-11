package alkemy.challenge.Challenge.Alkemy.dto;

import alkemy.challenge.Challenge.Alkemy.model.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDtoConverter {
    public OrganizationDto convertEntityToGetOrganizationDto(Organization orgDto) {
        return OrganizationDto.builder()
                .id(orgDto.getId())
                .name(orgDto.getName())
                .phone(orgDto.getPhone())
                .adress(orgDto.getAddress())
                .image(orgDto.getImage())
                .build();
    }

}
