package com.ratan.learn.restfull.springjpa;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    public static final Contact DEFAULT_CONTACT = new Contact("ratan", "www.ratan.com", "natar3829@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("spring-jpa api documentation", "documentation for basic apis", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");;
    private static final Set<String> DEFAULT_JSON_XML = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_JSON_XML).consumes(DEFAULT_JSON_XML);
        return docket;
    }
}
