package br.edu.ifpe.concursoideiasprofessoranjo.controller;

import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.NewUserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"spring.profiles.active=test"})
public class UserControllerTest {

    @Autowired
    private MockMvc _mockMvc;
    private final String newUser = "{\"email\": \"jadeilsonm@gmail.com\", \"name\":\"jadeilson martinho\",\"password\":\"senha1234\"}";
    @Test
    void ChecksIsReturnOk() throws Exception {
        final var response = _mockMvc.perform(get("/api/user/ok"));

        response
                .andExpect(status().isOk());
    }

    @Test
    void CreatedUser() throws Exception {

        final var response = _mockMvc.perform(
                post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newUser));

        response
                .andExpect(status().isCreated());


    }
}
