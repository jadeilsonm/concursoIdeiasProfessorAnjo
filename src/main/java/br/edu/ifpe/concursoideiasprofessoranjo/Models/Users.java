package br.edu.ifpe.concursoideiasprofessoranjo.Models;


import br.edu.ifpe.concursoideiasprofessoranjo.Shared.ERole;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(length = 75)
    @NotEmpty(message = "Name is required")
    @Length(min = 3, max = 75, message = "Name must be between 3 and 75 characters")
    private String name;
    @Column(length = 150)
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

    @Column(name = "role", length = 10)
    @JsonIgnore
    private ERole role = ERole.DEFAULT;

    @Column(name = "is_participant")
    @JsonIgnore
    private boolean isParticipant = false;

    @Column(name = "is_judge")
    @JsonIgnore
    private boolean isJudge = false;

    @Column(length = 11, unique = true)
    private String cpf;
    @Column(nullable = false)
    @NotEmpty(message = "Password is required")
    private String password;
    @Column
    private String image;

}
