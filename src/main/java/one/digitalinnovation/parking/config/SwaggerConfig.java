package one.digitalinnovation.parking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfos())
                .select()
                .apis(RequestHandlerSelectors.basePackage("one.digitalinnovation.parking.controller"))
                .apis(Predicate.not(RequestHandlerSelectors.basePackage("/basic-error-controller.*")))
                .build();
    }

    private ApiInfo apiInfos() {
        return new ApiInfoBuilder().
                title("Parking API")
                .description("Spring boot REST API for Parking Project")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }


}
