package br.edu.ifpe.concursoideiasprofessoranjo.Services;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.UserRepository;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.UserDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.ERole;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.Exception.PasswordInvalidException;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.Security.JwtService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServices implements UserDetailsService {


    private UserRepository repository;

    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    public UsersServices(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public Users CreateUser(Users users){
        return repository.save(EncryptPassword(users));
    }

    public List<UserDTO> GetUser(){
        var results = repository.findAll();
        var t = results.stream().map(u -> new UserDTO(u)).toList();
        return t;
    }


    public Users EncryptPassword(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return users;
    }

    public boolean IsValidPassword(String password, String passwordEncript){
        return passwordEncoder.matches(password, passwordEncript);
    }


    public String Auth(Users user){
        UserDetails userDetails = loadUserByUsername(user.getEmail());
        if(IsValidPassword(user.getPassword(), userDetails.getPassword())){
            Users userInf = repository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
            String token = jwtService.SetToken(userInf);
            return token;
        }
        throw new PasswordInvalidException();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        String[] roles = user.getRole() == ERole.ADMIN ?
                new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }

    public UserDTO createAdmin(Users users) {
        users.setRole(ERole.ADMIN);
        return new UserDTO(CreateUser(users));
    }

    public UserDTO createJury(Users users) {
        users.setJudge(true);
        return new UserDTO(CreateUser(users));
    }
}
