package alkemy.challenge.Challenge.Alkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import alkemy.challenge.Challenge.Alkemy.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
