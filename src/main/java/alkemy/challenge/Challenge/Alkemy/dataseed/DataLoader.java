package alkemy.challenge.Challenge.Alkemy.dataseed;

import alkemy.challenge.Challenge.Alkemy.model.*;
import alkemy.challenge.Challenge.Alkemy.repository.*;
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

    @Autowired
    SlideRepository slideRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        loadActivitiesData();
        loadNewsData();
        loadUsersData();
        loadSlidesData();
        loadMembersData();
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
        for (int i = 0; i < 5; i++) {
            newsRepository.save(new News("name", "imagePath", "content", category1));
            newsRepository.save(new News("name", "imagePath", "content", category2));
        }

    }

    private void loadUsersData() {
        Role userRol = new Role("ROLE_USER", "rol de user");
        Role adminRol = new Role("ROLE_ADMIN", "rol de admin");
        roleRepository.save(userRol);
        roleRepository.save(adminRol);
        userRepository.save(new User("firstName", "lastName", "user@alkemy.com", bCryptPasswordEncoder.encode("user"), "photo", userRol));
        userRepository.save(new User("firstName", "lastName", "admin@alkemy.com", bCryptPasswordEncoder.encode("admin"), "photo", adminRol));
        for (int i = 0; i < 10 ; i++) {
            userRepository.save(new User("firstName", "lastName", "user" + i + "@alkemy.com", bCryptPasswordEncoder.encode("user"), "photo", userRol));
            userRepository.save(new User("firstName", "lastName", "admin" + i + "@alkemy.com", bCryptPasswordEncoder.encode("admin"), "photo", adminRol));
        }
    }

    private void loadSlidesData() {
        Organization organization1 = new Organization("name", "image", "address", 123, "email", "welcomeText", "aboutUsText");
        Organization organization2 = new Organization("name", "image", "address", 123, "email", "welcomeText", "aboutUsText");
        organizationRepository.save(organization1);
        organizationRepository.save(organization2);
        for (int i = 1; i <= 5; i++) {
            slideRepository.save(new Slide( "imageUrl","text", i, organization1));
            slideRepository.save(new Slide("imageUrl","text", i, organization2));
        }
    }

    private void loadMembersData(){
        for (int i = 0; i < 10; i++) {
            memberRepository.save(new Member("name","facebookUrl","instagramUrl","linkedinUrl","image","description"));
        }
    }

}
