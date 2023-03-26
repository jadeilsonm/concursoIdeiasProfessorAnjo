package br.edu.ifpe.concursoideiasprofessoranjo.Models;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column
    @NotEmpty(message = "Name is required")
    private String name;
    @Column
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(name = "role", length = 10)
    @JsonIgnore
    private String role = "default";

    @Column
    private String cpf;
    @Column
    @NotEmpty(message = "Email is required")
    private String password;
    @Column
    private String image;

}
