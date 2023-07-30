package br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsDTO
{
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    private List<Integer> members;
    @Min(1)
    private Integer leader;

}
