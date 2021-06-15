package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.EmailRequest;
import alkemy.challenge.Challenge.Alkemy.service.EmailService;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailrequest) {
        Response response = emailService.sendEmail(emailrequest);
        if (response.getStatusCode() == 200 || response.getStatusCode() == 202) {
            return new ResponseEntity<>("Mail enviado!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fallo el envio!", HttpStatus.NOT_FOUND);
    }

//    Json para probar el método:
//    
//    {
//    "to":"mail_cliente@mail.com",
//    "subject":"Formulario completado / Registro exitoso, etc..",
//    "body":"Cuerpo del mail."
//    }
}
