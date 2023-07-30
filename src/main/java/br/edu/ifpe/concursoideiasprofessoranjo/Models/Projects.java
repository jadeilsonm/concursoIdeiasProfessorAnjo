package br.edu.ifpe.concursoideiasprofessoranjo.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column
    private String description;
    @Column
    private Integer leader;
    @OneToMany( mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true )
    public List<Users> members;
}
