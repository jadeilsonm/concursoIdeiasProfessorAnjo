package br.edu.ifpe.concursoideiasprofessoranjo.Services;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Projects;
import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.PorjectRepository;
import br.edu.ifpe.concursoideiasprofessoranjo.Repositorys.UserRepository;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.ProjectMemberDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.ProjectsDTO;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private PorjectRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<Projects> getProjects(){
        return repository.findAll();
    }

    @Transactional
    public ProjectMemberDTO CreateProject(ProjectsDTO p){
        var project = new Projects();
        project.setTitle(p.getTitle());
        project.setDescription(p.getDescription());
        var allUserInterger = p.getMembers();
        allUserInterger.add(p.getLeader());
        var users = ChangeIsParticipating(GetUsers(allUserInterger));
        project.setMembers(users);
        var projectSave = repository.save(project);
        var allUser = projectSave.getMembers();
        var time = allUser.stream().filter(u -> u.getId() != p.getLeader()).toList();
        var leader = allUser.stream().filter(u -> u.getId() == p.getLeader())
                .findAny()
                .orElse(null);

        return new ProjectMemberDTO(projectSave.getId(),
                projectSave.getTitle(),
                projectSave.getDescription(),
                ConvertToUserForUserDTO(time),
                new UserDTO(leader != null ? leader : new Users()));
    }

    private List<Users> GetUsers(List<Integer> ids){
        return userRepository.findAllById(ids);
    }

    private List<Users> ChangeIsParticipating(List<Users> users){
        return users.stream().map(u -> {
            u.setParticipant(true);
            return userRepository.save(u);
        }).toList();
    }

    private List<UserDTO> ConvertToUserForUserDTO(List<Users> users){
        return users.stream().map(u -> new UserDTO(u)).toList();
    }

}
