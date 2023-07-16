package br.edu.ifpe.concursoideiasprofessoranjo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@OpenAPIDefinition(info = @Info(
        title = "CIPA",
        version = "1.0",
        description = "backend responsavel por persistir dados dos alunos participantes do envento",
        contact = @Contact(name = "Jadeilson Dev Backend CIPA",
                url = "https://api.whatsapp.com/send?phone=5581992167390",
                email = "jms@a.palmares.ifpe.edu.br"),
        license = @License(name = "Apache 2.0",
                url = "http://www.apache.org/licenses/LICENSE-2.0.html")
),
        servers = {
        @Server(url = "https://defective-support-production.up.railway.app/", description = "Server produção"),
        @Server(url = "http://localhost:8080/", description = "Server local")}
)
@SecurityScheme(name = "Auth", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, description = "Token JWT gerado na '/api/user/auth'")
public class ConcursoIdeiasProfessorAnjoApplication {


    public static void main(String[] args) {
       // System.setProperty("spring.profiles.active", "test");
        SpringApplication.run(ConcursoIdeiasProfessorAnjoApplication.class, args);
    }
}
