package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Category;
import alkemy.challenge.Challenge.Alkemy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    /*Obtener lista de categorias por nombres*/
    public List<String> listCategoriesByName() {
        List<Category> listCategories = categoryRepository.findAll();
        List<String> listCategoriesByname = new ArrayList<>();
        for (Category c : listCategories) {
            listCategoriesByname.add(c.getName());
        }
        return listCategoriesByname;
    }

    public boolean createCategories(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //obtain a list of pages categories by page number, page size and sort By parameters
    public List<Category> getAllCategoriesPages(int pageNo, int pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Category> pagedResult = categoryRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Category>();
        }
    }


    public boolean existsById(Long id) {
        return categoryRepository.existsById(id);
    }

    public Optional<Category> getOne(Long id) {
        return categoryRepository.findById(id);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }


}
