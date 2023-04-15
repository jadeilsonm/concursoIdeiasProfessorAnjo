package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Projects;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<Projects> GetProject(){
        return service.getProjects();
    }
}
