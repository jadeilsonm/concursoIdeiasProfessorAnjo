package br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs;

import br.edu.ifpe.concursoideiasprofessoranjo.Shared.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {

    private String name;
    private String email;
    private String password;
    private String cpf;
}
