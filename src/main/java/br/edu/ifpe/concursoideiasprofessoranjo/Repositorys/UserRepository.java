package br.edu.ifpe.concursoideiasprofessoranjo.Repositorys;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);

    void deleteByEmail(String email);

    Optional<Users> findByEmailAndPassword(String email, String password);
}
