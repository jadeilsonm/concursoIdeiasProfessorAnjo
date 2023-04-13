package br.edu.ifpe.concursoideiasprofessoranjo.Models;

import javax.persistence.*;
import java.time.LocalDate;

public class Events {

    static final LocalDate initial = LocalDate.now();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate dateInitial = initial;

    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate dateFinal = initial.plusDays(10);

}
