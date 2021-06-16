package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Category;
import alkemy.challenge.Challenge.Alkemy.service.CategoryService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<?> addCategories(@RequestBody @Valid Category category) {
        if (StringUtils.isBlank(category.getName())) {
            return new ResponseEntity(new Message("campo nombre no puede estar vacio."),
                    HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.isAlpha(category.getName())) {
            return new ResponseEntity(new Message("Debe contener solo letras."),
                    HttpStatus.BAD_REQUEST);
        } else {
            categoryService.createCategories(category);
            return new ResponseEntity(new Message("categoria creada."),
                    HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @RequestBody Category category) {

        if (!categoryService.existsById(id)) {
            return new ResponseEntity(new Message("no existe el id"),
                    HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(category.getName())) {
            return new ResponseEntity(new Message("campo nombre no puede estar vacio"),
                    HttpStatus.BAD_REQUEST);
        }

        if (!StringUtils.isAlpha(category.getName())) {
            return new ResponseEntity(new Message("Debe contener solo letras"),
                    HttpStatus.BAD_REQUEST);
        }

        Category categorieUpdated = categoryService.getOne(id).get();
        categorieUpdated.setName(category.getName());
        categorieUpdated.setDescription(category.getDescription());
        categorieUpdated.setImages(category.getImages());
        categoryService.save(categorieUpdated);
        return new ResponseEntity(new Message("Categoria actualizada"),
                HttpStatus.OK);
    }
}
