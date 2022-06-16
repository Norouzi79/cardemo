package com.alinorouzi.cardemo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi employeesOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = {"/car/**"};
        return GroupedOpenApi.builder()
                .group("demo")
                .addOpenApiCustomiser(openApi ->
                        springOpenAPI())
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Car Demo")
                        .contact(new Contact()
                                .name("Ali Norouzi")
                                .email("alinorouzi79@gmail.com")
                                .url("https://www.linkedin.com/in/norouzi79/"))
                        .version("1.0"));
    }
}