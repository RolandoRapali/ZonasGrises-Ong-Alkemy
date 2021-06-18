package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.EmailRequest;
import alkemy.challenge.Challenge.Alkemy.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/sendEmail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmailTo")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailrequest) {
        Response response = emailService.sendEmail(emailrequest);
        if (response.getStatusCode()==200||response.getStatusCode()==202)
            return new ResponseEntity<>("Mail enviado!", HttpStatus.OK);
        return new ResponseEntity<>("Fallo el envio!", HttpStatus.NOT_FOUND);
    }



}

//    Json para probar el método:
//    
//    {
//    "to":"mail_cliente@mail.com",
//    "subject":"Formulario completado / Registro exitoso, etc..",
//    "body":"Cuerpo del mail."
//    }

