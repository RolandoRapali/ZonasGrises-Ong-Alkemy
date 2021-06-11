package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Categories;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import alkemy.challenge.Challenge.Alkemy.service.CategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/categories")
    public ResponseEntity<?> addCategories(@RequestBody @Valid Categories categories) {
        if (StringUtils.isBlank(categories.getName())) {
            return new ResponseEntity(new Message("campo nombre no puede estar vacio."),
                    HttpStatus.BAD_REQUEST);
        }

        if (!StringUtils.isAlpha(categories.getName())) {
            return new ResponseEntity(new Message("Debe contener solo letras."),
                    HttpStatus.BAD_REQUEST);
        } else {
            categoriesService.createCategories(categories);
            return new ResponseEntity(new Message("categoria creada."),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> detailsCategories(@RequestBody Categories categories, @PathVariable("id") Long id) {
        Categories categoriesAux = categoriesService.findById(id);
        if (!(categoriesAux == null)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(categoriesAux);

    }

}
