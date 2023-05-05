package br.edu.ifpe.concursoideiasprofessoranjo.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
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
