package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import alkemy.challenge.Challenge.Alkemy.repository.MemberRepository;
import alkemy.challenge.Challenge.Alkemy.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping
    public ResponseEntity<?> newMember(@Valid @RequestBody Member member, BindingResult result){

        Map<String, Object> response = new HashMap<>();
        errorHandlingService.registerErrorHandling(result, response);

        try{
            memberRepository.save(member);
        }catch (Exception e){
            response.put("message", "ERROR DB");
            response.put("error_member", e.getMessage().concat(":"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("member",member);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


    @GetMapping
    public List<Member> listMembers(){
        return (List<Member>) memberRepository.findAll();
    }

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
