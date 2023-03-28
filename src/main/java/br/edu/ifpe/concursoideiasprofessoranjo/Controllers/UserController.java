package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServices services;

    @PostMapping
    @PermitAll
    @ResponseStatus(HttpStatus.CREATED)
    public Users CreateUser(@RequestBody Users u){

        return services.CreateUser(u);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<Users> GetUser(){
        return services.GetUser();
    }

}
