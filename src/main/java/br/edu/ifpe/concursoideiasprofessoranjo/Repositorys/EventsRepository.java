package br.edu.ifpe.concursoideiasprofessoranjo.Repositorys;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Integer, Events> {
}
