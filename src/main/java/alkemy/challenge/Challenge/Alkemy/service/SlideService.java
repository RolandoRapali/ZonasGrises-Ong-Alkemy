package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.converter.Base64ConverterMultipartFile;
import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.repository.SlideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64.Decoder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SlideService {

    /* Inyeccion para decodificar un archivo base 64 */
    @Autowired
    private Decoder decoder;

    @Autowired
    private SlideRepository slideRepository;

    /* Inyeccion de clase creada para convertir archivo base 64 a MultipartFile*/
    @Autowired
    private Base64ConverterMultipartFile base64ConverterMultipartFile;

    /*Metodo para convertir archivo base64 a multipartFile para luego poder almacenarlo en amazonS3*/
    public MultipartFile convertMultipartFile(byte[] file){
        /*Convierto el archivo base64 en string*/
        String stringFile = decoder.decode(file).toString();
        return base64ConverterMultipartFile.base64ToMultipart(stringFile);
    }

    public void createSlide(byte[] file, Slide slide){
        /*Guardo valores en los campos del Slide creado*/
        slide.setImageUrl(convertMultipartFile(file));
        slide.setText(slide.getText());
        slide.setSequence(slide.getSequence());
        slide.setCreatedAt(slide.getCreatedAt());
        slide.setUpdatedAt(slide.getUpdatedAt());
        slideRepository.save(slide);
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
