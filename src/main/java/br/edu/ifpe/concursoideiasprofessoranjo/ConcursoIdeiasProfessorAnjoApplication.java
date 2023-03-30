package br.edu.ifpe.concursoideiasprofessoranjo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "CIPA",
        version = "1.0",
        description = "backend responsavel por persistir dados dos alunos participantes do envento"
))
public class ConcursoIdeiasProfessorAnjoApplication {


    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "development");
        SpringApplication.run(ConcursoIdeiasProfessorAnjoApplication.class, args);
    }
}
