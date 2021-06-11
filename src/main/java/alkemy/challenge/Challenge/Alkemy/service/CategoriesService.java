package alkemy.challenge.Challenge.Alkemy.service;

import java.util.ArrayList;
import java.util.List;
import alkemy.challenge.Challenge.Alkemy.model.Categories;
import alkemy.challenge.Challenge.Alkemy.repository.CategoriesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    /*Obtener lista de categorias por nombres*/
    public List<String> listCategoriesByName() {
        List<Categories> listCategories = categoriesRepository.findAll();
        List<String> listCategoriesByname = new ArrayList<>();
        for (Categories c : listCategories) {
            listCategoriesByname.add(c.getName());
        }
        return listCategoriesByname;
    }

    public boolean createCategories(Categories categories) {
        try {
            categoriesRepository.save(categories);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    Obtener listado de Categoria segun id  
    public Categories findById(long id) {

        return categoriesRepository.findById(id);
    }

}
