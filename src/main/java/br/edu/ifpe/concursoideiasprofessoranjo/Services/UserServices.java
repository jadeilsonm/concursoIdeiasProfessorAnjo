package br.edu.ifpe.concursoideiasprofessoranjo.Services;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Users CreateUser(Users users){
        return repository.save(EncryptPassword(users));
    }

    public Users EncryptPassword(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return users;
    }

}
