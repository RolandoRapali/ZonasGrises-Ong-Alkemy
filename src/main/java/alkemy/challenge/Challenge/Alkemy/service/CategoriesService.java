package alkemy.challenge.Challenge.Alkemy.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alkemy.challenge.Challenge.Alkemy.model.Categories;

@Service
public class CategoriesService {

    /*Obtener lista de categorias por nombres*/
    public List<String> listCategoriesByName(List<Categories> listCategories){
        List<String> listCategoriesByname = new ArrayList<>();
        for (Categories c : listCategories) {
            listCategoriesByname.add(c.names);
        }
        return listCategoriesByname;
    }
}
