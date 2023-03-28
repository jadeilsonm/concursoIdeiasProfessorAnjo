package br.edu.ifpe.concursoideiasprofessoranjo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.profiles.active=test"})
class ConcursoIdeiasProfessorAnjoApplicationTests {


    @Autowired
    private ConcursoIdeiasProfessorAnjoApplication application;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(application);
    }

}
