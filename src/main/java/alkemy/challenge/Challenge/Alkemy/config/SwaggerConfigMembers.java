package alkemy.challenge.Challenge.Alkemy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfigMembers {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelector.basePackage("alkemy.challenge.Challenge.Alkemy.controller.MemberController"))
                .paths(PathSelectors.any())
                .build();
    }


}
