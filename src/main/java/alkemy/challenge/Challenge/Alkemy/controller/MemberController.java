package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import alkemy.challenge.Challenge.Alkemy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Member> listMembers(){
        return (List<Member>) memberRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable(value = "id") Long id){
        Map<String, Object> response = new HashMap<>();

        if(id > 0){
            Member member = memberRepository.findById(id).orElse(null);
            memberRepository.deleteById(id);
            if(member == null){
                response.put("member_null","Member doesn't exist");
            }
        } else {
            response.put("id_0","The ID cannot be 0");
        }

    }

    

}
