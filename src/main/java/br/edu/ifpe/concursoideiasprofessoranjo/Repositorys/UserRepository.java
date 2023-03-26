package br.edu.ifpe.concursoideiasprofessoranjo.Repositorys;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
