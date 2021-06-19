package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.converter.Base64ConverterMultipartFile;
import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.repository.SlideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64.Decoder;

@Service
@RequiredArgsConstructor
public class SlideService {

    /* Inyeccion para decodificar un archivo base 64 */
    /*@Autowired
    private Decoder decoder;*/
    
    /* Inyeccion de clase creada para convertir archivo base 64 a MultipartFile*/
    @Autowired
    private Base64ConverterMultipartFile base64ConverterMultipartFile;

    @Autowired
    private SlideRepository slideRepository;
    
    @Autowired
    private AmazonClientService amazonClientService;

    
    public List<String> listSlides(){
        List<Slide> listSlide = slideRepository.findAll();
        List<String> listImageSequence = new ArrayList<>();
        for (Slide s : listSlide) {
            listImageSequence.add(String.valueOf(s.getImageUrl()));
            listImageSequence.add(String.valueOf(s.getSequence()));
        }
        return listImageSequence;
    }
    
    public ResponseEntity<Slide> detailSlide(Long id) {
        if (slideRepository.existsById(id)) {
            Slide s = slideRepository.getById(id);
            return ResponseEntity.ok(s);
        }
        return (ResponseEntity<Slide>) ResponseEntity.notFound();
    }

    /*Metodo para convertir archivo String a multipartFile para luego poder almacenarlo en amazonS3*/
    public MultipartFile convertMultipartFile(String file){
        return base64ConverterMultipartFile.base64ToMultipart(file);
    }

    public void createSlide(byte[] file, Slide slide){
        String imageUrl = file.toString();
        slide.setImageUrl(imageUrl);
        slideRepository.save(slide);
        amazonClientService.uploadFile(convertMultipartFile(imageUrl));
    }

    public List<Slide> findSlidesByOrganization(Long id) {
        return slideRepository.findByOrganizationIdOrderBySequence(id);
    }
    
    public ResponseEntity<Slide> updateSlide(Long id, Slide slideDetail){
        if (slideRepository.existsById(id)){
            Slide slide = slideRepository.getById(id);
            slide.setImageUrl(slideDetail.getImageUrl());
            slide.setText(slideDetail.getText());
            slide.setSequence(slideDetail.getSequence());
            slide.setCreatedAt(slideDetail.getCreatedAt());
            slide.setUpdatedAt(slideDetail.getUpdatedAt());
            final Slide updatSlide = slideRepository.save(slide);
            amazonClientService.uploadFile(convertMultipartFile(updatSlide.getImageUrl()));
            return ResponseEntity.ok(updatSlide);
        }
        return (ResponseEntity<Slide>) ResponseEntity.notFound();
    }

    public ResponseEntity<Slide> deletedSlide(Long id){
        if(slideRepository.existsById(id)){
            Slide s = slideRepository.getById(id);
            slideRepository.delete(s);
            return (ResponseEntity<Slide>) ResponseEntity.ok();
        }
        return (ResponseEntity<Slide>) ResponseEntity.notFound();
    }
}
