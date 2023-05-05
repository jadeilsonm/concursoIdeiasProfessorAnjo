package br.edu.ifpe.concursoideiasprofessoranjo.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "companies")
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Name is required")
    @Length(min = 3, max = 150, message = "Name must be between 3 and 150 characters")
    private String name;
    @Column(unique = true, length = 14)
    private String cnpj;
    @Column
    private String contact = "Não informado";
    @Column
    private String image;
}
