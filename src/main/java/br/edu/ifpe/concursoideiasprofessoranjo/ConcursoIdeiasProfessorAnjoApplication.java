package br.edu.ifpe.concursoideiasprofessoranjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConcursoIdeiasProfessorAnjoApplication {


    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "development");
        SpringApplication.run(ConcursoIdeiasProfessorAnjoApplication.class, args);
    }
}
