package br.edu.ifpe.concursoideiasprofessoranjo.Repositorys;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorjectRepository extends JpaRepository<Projects, Integer> {
}
