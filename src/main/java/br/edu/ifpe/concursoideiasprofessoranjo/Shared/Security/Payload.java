package br.edu.ifpe.concursoideiasprofessoranjo.Shared.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    private String name;
    private String email;
    private String cpf;
    private Integer id;
}
