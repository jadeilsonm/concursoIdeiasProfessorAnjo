package br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberDTO {
    private Integer id;
    private String title;
    private String description;
    private List<UserDTO> members;
}
