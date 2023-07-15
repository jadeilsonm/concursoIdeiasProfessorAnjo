package br.edu.ifpe.concursoideiasprofessoranjo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@OpenAPIDefinition(info = @Info(
        title = "CIPA",
        version = "1.0",
        description = "backend responsavel por persistir dados dos alunos participantes do envento"
))
@SecurityScheme(name = "Auth", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, description = "Token JWT gerado na '/api/user/auth'")
public class ConcursoIdeiasProfessorAnjoApplication {


    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test");
        SpringApplication.run(ConcursoIdeiasProfessorAnjoApplication.class, args);
    }
}
