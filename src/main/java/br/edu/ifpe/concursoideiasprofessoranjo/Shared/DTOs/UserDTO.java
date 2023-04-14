package br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Shared.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private ERole role;
    private String cpf;
    private String image;

    public UserDTO(Users user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        role = user.getRole();
        cpf = user.getCpf();
        image = user.getImage();
    }

}
