package br.edu.ifpe.concursoideiasprofessoranjo.Services;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Projects;
import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.PorjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private PorjectRepository repository;

    public List<Projects> getProjects(){
        return repository.findAll();
    }

}
