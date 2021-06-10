package alkemy.challenge.Challenge.Alkemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import alkemy.challenge.Challenge.Alkemy.service.AmazonClientService;

@RestController
@RequestMapping("/storage")
public class AmazonClientController {
    
    private AmazonClientService amazonClient;

    @Autowired
    AmazonClientController(AmazonClientService amazonClient) {
        this.amazonClient = amazonClient;
    }
    /*Endpoint para subir imagen */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }
}
