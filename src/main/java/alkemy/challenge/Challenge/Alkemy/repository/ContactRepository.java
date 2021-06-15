package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
