package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.PorjectRepository;
import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.UserRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = { "spring.profiles.active=test" })
class ProjectControllerTest {

    @Autowired
    private MockMvc _mockMvc;

    @Autowired
    private UserRepository _repositoryUser;
    @Autowired
    private PorjectRepository _repositoryProject;
    private String token;
    private final String auth = "{\"email\": \"test@test.com\", \"password\":\"password1234\"}";
    private String usersTest = "{\"email\": \"test@test.com\", \"name\":\"test junit\",\"password\":\"password1234\"}";

    @BeforeEach
    void setUp() throws Exception {
        usersTest = _mockMvc.perform(
                        post("/api/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(usersTest))
                .andReturn()
                .getResponse()
                .getContentAsString();

        token = _mockMvc.perform(post(new URI("/api/user/auth"))
                        .content(auth)
                        .header( "access-control-max-age", 3600 )
                        .header("content-type", "application/json"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @AfterEach
    void tearDown() {
        _repositoryUser.deleteAll();
    }

    @Test
    void getProject() throws Exception {
        final var response = _mockMvc.perform(get("/api/project/")
                .header("Authorization", getToken(token)));
        response
                .andExpect(status().isOk());
    }

    @Test
    void createProject() {
    }

    private String getToken(String body) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(body, JsonObject.class);
        return "Bearer " + json.get("token").getAsString();
    }
}