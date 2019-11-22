package com.proj.olxshopv1.Configuration;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SpringBoot-Swagger-API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.proj.olxshopv1.Controller"))
                .build()
                .apiInfo(metaData())
                .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("KindGeek Java School using Swagger")
                .description("\"REST API \"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Test Contact", "http://test.com", "test@test.com"))
                .build();
    }
}

