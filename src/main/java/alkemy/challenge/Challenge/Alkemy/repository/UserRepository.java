package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    //Soft Delete Query's
//    @Query("UPDATE FROM users SET deleted = 1 WHERE id = ?1")
//    public void deleteUser(Long id);
//
//    @Query("SELECT * FROM users WHERE deleted = 0")
//    public List<User> usersWithStatusActive();

    Optional<User> findByEmail(String email);

}
