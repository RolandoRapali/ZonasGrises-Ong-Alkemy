package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.converter.Base64ConverterMultipartFile;
import lombok.RequiredArgsConstructor;
import java.util.Base64.Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class SlideService {

    /* Inyeccion para decodificar un archivo base 64 */
    @Autowired
    private Decoder decoder;

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
}
