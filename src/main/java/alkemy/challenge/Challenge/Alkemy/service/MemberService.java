package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import alkemy.challenge.Challenge.Alkemy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> memberList(){
        return (List<Member>) memberRepository.findAll();
    }

    public Member findById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    /*@Transactional
    public Page<Member> findAllByPage(Pageable pageable) throws Exception{
        try{
            Page<Member> memberByPage = memberRepository.findAllByPage(pageable);
            return memberByPage;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/

    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    public void save(Member member){
        memberRepository.save(member);
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }
}
