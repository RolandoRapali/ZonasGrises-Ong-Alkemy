package alkemy.challenge.Challenge.Alkemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import alkemy.challenge.Challenge.Alkemy.repository.IMembersRepository;

@Controller
public class MembersController {

    @Autowired
    private IMembersRepository membersRepository;

}
