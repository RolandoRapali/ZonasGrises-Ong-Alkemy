package alkemy.challenge.Challenge.Alkemy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import alkemy.challenge.Challenge.Alkemy.model.Categories;
import alkemy.challenge.Challenge.Alkemy.repository.CategoriesRepository;
import alkemy.challenge.Challenge.Alkemy.service.CategoriesService;

@RestController
public class CategoriesController {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/categories")
    public String listCategoriesByName(Model model){
        List<Categories> listCategories = categoriesRepository.findAll();
        /*Hago impresion de la lista con las categorias por nombre*/
        System.out.println("List of Categories: "+ categoriesService.listCategoriesByName(listCategories));
        /*Mando la lista a la vista*/
        model.addAttribute("listCategories", categoriesService.listCategoriesByName(listCategories));
        return "categoriesView";
    }
}
