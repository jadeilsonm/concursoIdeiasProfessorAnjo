package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServices services;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Users CreateUser(@RequestBody Users u){
        return services.CreateUser(u);
    }
}
