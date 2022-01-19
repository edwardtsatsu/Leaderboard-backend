package com.group8.Leaderboardbackend.swagger.configs;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new
                Docket(DocumentationType.SWAGGER_2)
                .groupName("Group 8")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/v1/leaderboard.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new
                ApiInfoBuilder().title("Leaderboard Service")
                .description("Documentation Generated for using group 8 leaderboard application")
                .termsOfServiceUrl("https://github.com/justice-aasre")
                .license("Group 8 license")
                .licenseUrl("https://app.hibob.com")
                .version("v1.0")
                .build();
    }

}
