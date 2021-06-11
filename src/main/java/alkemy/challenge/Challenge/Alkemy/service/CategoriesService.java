package alkemy.challenge.Challenge.Alkemy.service;

import java.util.ArrayList;
import java.util.List;
import alkemy.challenge.Challenge.Alkemy.model.Categories;
import alkemy.challenge.Challenge.Alkemy.repository.CategoriesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public boolean existsById(Long id){
        return categoriesRepository.existsById(id);
    }
    
    public Optional<Categories> getOne(Long id){
        return categoriesRepository.findById(id);
    }
    
    public void save(Categories categories){
        categoriesRepository.save(categories);
    }
}
