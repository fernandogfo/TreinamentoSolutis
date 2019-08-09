package com.contas.solutis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

//Pelo que eu vi na net o Swagger ele auxilia na documentação do projeto, testes entre outros
//Enquanto faço o projeto estou pesquisando como usar
@Configuration
@EnableSwagger2
@ComponentScan("com.contas.solutis")
public class SwaggerConfig {

    @Bean
    public Docket contaApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.contas.solutis"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Conta API REST",
                "API REST de contas a receber e a pagar",
                "1.0",
                "Termos de Serviço",
                new Contact( "Fernando Oliveira", "https://www.facebook.com/ferna.drluna",
                        "ferna126@hotmail.com"),
                "Nenhuma até o momento",
                "sem nada por enquanto", new ArrayList<>());
        return apiInfo;
    }



}
