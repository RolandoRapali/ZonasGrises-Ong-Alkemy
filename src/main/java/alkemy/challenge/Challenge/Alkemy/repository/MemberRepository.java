package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /*Page<Member> findAllByPage(Pageable pageable);

    @Query(value = "SELECT * FROM members LIKE %:pageable%", countQuery = "SELECT count(*)  FROM members", nativeQuery = true)
    Page<Member> getMemberOfPage(Pageable pageable);*/

}
