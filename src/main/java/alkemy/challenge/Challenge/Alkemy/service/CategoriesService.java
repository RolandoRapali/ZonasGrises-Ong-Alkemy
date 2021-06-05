package alkemy.challenge.Challenge.Alkemy.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alkemy.challenge.Challenge.Alkemy.model.Categories;
import alkemy.challenge.Challenge.Alkemy.repository.CategoriesRepository;
@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    /*Obtener lista de categorias por nombres*/
    public List<String> listCategoriesByName(){
        List<Categories> listCategories = categoriesRepository.findAll();
        List<String> listCategoriesByname = new ArrayList<>();
        for (Categories c : listCategories) {
            listCategoriesByname.add(c.names);
        }
        return listCategoriesByname;
    }
}
