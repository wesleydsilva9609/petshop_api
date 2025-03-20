package br.com.alura.Petshop_api.infra.springdocs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Petshop-API")
                        .description("Petshop-api para agendamento de consultas")
                        .contact(new Contact().name("Wesley Silva").email("wesleydsilva96@gmail.com")).license(new License().name("apache 2.0")));
    }
}
