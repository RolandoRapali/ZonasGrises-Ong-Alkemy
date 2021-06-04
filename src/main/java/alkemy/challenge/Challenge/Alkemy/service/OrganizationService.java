package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

}
