package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.UsersServices;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.CredentialDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.TokenDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.UserDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.Exception.PasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.PermitAll;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private UsersServices userServices;

    public UserController(UsersServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    @PermitAll
    public ResponseEntity<Users> CreateUser(@RequestBody Users u){
        return new ResponseEntity(userServices.CreateUser(u), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> GetUser(){
        return new ResponseEntity(userServices.GetUser(), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredentialDTO credential){
        System.out.println("autenticar");
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
