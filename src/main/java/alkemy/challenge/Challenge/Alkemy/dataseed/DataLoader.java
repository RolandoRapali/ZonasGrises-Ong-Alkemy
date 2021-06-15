package alkemy.challenge.Challenge.Alkemy.dataseed;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.model.Category;
import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.model.Role;
import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.repository.ActivityRepository;
import alkemy.challenge.Challenge.Alkemy.repository.CategoryRepository;
import alkemy.challenge.Challenge.Alkemy.repository.NewsRepository;
import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import alkemy.challenge.Challenge.Alkemy.repository.RoleRepository;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public void run(String... args) throws Exception {
        loadActivitiesData();
        loadNewsData();
        loadUsersData();
    }

    private void loadActivitiesData() {
        if (activityRepository.count() == 0) {
            Activity activity1 = new Activity(
                    "NombreActividadPRUEBA1",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad");
            Activity activity2 = new Activity(
                    "NombreActividadPRUEBA2",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad");
            activityRepository.save(activity1);
            activityRepository.save(activity2);
        }
        System.out.println(activityRepository.count());
    }

    private void loadNewsData() {
        Category category1 = new Category("name", "description", "imagePath");
        Category category2 = new Category("name", "description", "imagePath");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        newsRepository.save(new News("name", "imagePath", "content", category1));
        newsRepository.save(new News("name", "imagePath", "content", category2));
    }

    private void loadUsersData() {
        Role userRol = new Role("ROLE_USER", "rol de user");
        Role adminRol = new Role("ROLE_ADMIN", "rol de admin");
        roleRepository.save(userRol);
        roleRepository.save(adminRol);
        userRepository.save(new User("firstName", "lastName", "user@alkemy.com", bCryptPasswordEncoder.encode("user"), "photo", userRol));
        userRepository.save(new User("firstName", "lastName", "admin@alkemy.com", bCryptPasswordEncoder.encode("admin"), "photo", adminRol));
    }

}
