package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Member;
import alkemy.challenge.Challenge.Alkemy.repository.MemberRepository;
import alkemy.challenge.Challenge.Alkemy.service.MemberService;
import com.amazonaws.services.xray.model.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @GetMapping("/page")
    public ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "0") int page) {

        try {
            Pageable pageRequest = PageRequest.of(page, 10);
            Page<Member> memberPage = memberRepository.getMemberOfPage(pageRequest);
            return ResponseEntity.status(HttpStatus.OK).body(memberPage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error. Please try again.");
        }
    }


}
