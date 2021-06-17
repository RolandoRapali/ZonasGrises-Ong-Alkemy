package alkemy.challenge.Challenge.Alkemy.config;

import alkemy.challenge.Challenge.Alkemy.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //Api rest documentation using Swagger2
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "alkemy.challenge.Challenge.Alkemy.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
