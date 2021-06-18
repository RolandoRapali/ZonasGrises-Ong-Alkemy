package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    Page<Member> findAllByPage(Pageable pageable);


    @Query(value = "SELECT * FROM members LIKE %:pageable%", countQuery = "SELECT count(*)  FROM members", nativeQuery = true)
    Page<Member> getMemberOfPage(Pageable pageable);
}
