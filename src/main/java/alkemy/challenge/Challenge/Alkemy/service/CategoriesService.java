package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Category;
import alkemy.challenge.Challenge.Alkemy.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    /*Obtener lista de categorias por nombres*/
    public List<String> listCategoriesByName() {
        List<Category> listCategories = categoriesRepository.findAll();
        List<String> listCategoriesByname = new ArrayList<>();
        for (Category c : listCategories) {
            listCategoriesByname.add(c.getName());
        }
        return listCategoriesByname;
    }

    public boolean createCategories(Category category) {
        try {
            categoriesRepository.save(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean existsById(Long id) {
        return categoriesRepository.existsById(id);
    }

    public Optional<Category> getOne(Long id) {
        return categoriesRepository.findById(id);
    }

    public void save(Category category) {
        categoriesRepository.save(category);
    }
}
