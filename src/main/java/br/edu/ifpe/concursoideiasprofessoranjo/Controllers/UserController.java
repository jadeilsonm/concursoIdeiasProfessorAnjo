package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.UsersServices;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.CredentialDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.NewUserDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.TokenDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.UserDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.Exception.PasswordInvalidException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private UsersServices userServices;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UsersServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    @PermitAll
    public ResponseEntity<Users> CreateUser(@Valid @RequestBody NewUserDTO u){
        logger.info("Initializando creted user" + u);
        return new ResponseEntity(userServices.CreateUser(u), HttpStatus.CREATED);
    }

    @GetMapping("/ok")
    public String Ok(){
        return "Ok";
    }

    @GetMapping
    @SecurityRequirement(name = "Auth")
    public ResponseEntity<List<UserDTO>> GetUser(){
        return new ResponseEntity(userServices.GetUser(), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredentialDTO credential){
        logger.info("Initializando cautentication" + credential);
        try{
            Users user = Users.builder()
                    .email(credential.getEmail())
                    .password(credential.getPassword())
                    .build();

            var token = userServices.Auth(user);

            return new TokenDTO(token);
        } catch (UsernameNotFoundException | PasswordInvalidException e ){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}
