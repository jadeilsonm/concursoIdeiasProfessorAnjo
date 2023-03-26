package br.edu.ifpe.concursoideiasprofessoranjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConcursoIdeiasProfessorAnjoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcursoIdeiasProfessorAnjoApplication.class, args);
        System.out.println("Server Up port 8080");
    }
}
