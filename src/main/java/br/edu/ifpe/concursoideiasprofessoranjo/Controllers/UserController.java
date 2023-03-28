package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Users> CreateUser(@RequestBody Users u){
        return new ResponseEntity(services.CreateUser(u), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Users>> GetUser(){
        return new ResponseEntity(services.GetUser(), HttpStatus.OK);
    }

    public void setServices(UserServices services) {
        this.services = services;
    }
}
