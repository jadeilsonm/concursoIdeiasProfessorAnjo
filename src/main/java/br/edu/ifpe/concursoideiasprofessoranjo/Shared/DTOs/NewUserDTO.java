package br.edu.ifpe.concursoideiasprofessoranjo.Shared.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {
    
    @Size(min = 3, message = "size min required is 3")
    private String name;
    @Email(message = "Email is required")
    private String email;

    @Size(min = 6, message = "lengh min is 3")
    private String password;
    @Size(min = 11, max = 15, message = "lengh min is 3")
    private String cpf;
}
