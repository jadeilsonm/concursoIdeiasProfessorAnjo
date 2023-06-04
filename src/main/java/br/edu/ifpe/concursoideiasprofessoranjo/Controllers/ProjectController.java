package br.edu.ifpe.concursoideiasprofessoranjo.Controllers;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Projects;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.ProjectService;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.ProjectMemberDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.ProjectsDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    @SecurityRequirement(name = "Auth")
    public List<Projects> GetProject() {
        return service.getProjects();
    }

    @PostMapping
    @SecurityRequirement(name = "Auth")
    public ProjectMemberDTO CreateProject(@RequestBody ProjectsDTO p) {
        return service.CreateProject(p);
    }
}
