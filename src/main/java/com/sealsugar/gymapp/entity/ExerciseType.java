package com.sealsugar.gymapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercise_type")
public class ExerciseType {

    @Id
    @SequenceGenerator(
            name = "exercise_type_sequence",
            sequenceName = "exercise_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "exercise_type_sequence"
    )
    @Column(
            name = "exercise_type_ID",
            updatable = false
    )
    private Long exerciseTypeId;

    @Column(
            name = "type",
            columnDefinition = "varchar(255)"
    )
    private String type;

    public enum Exercise {
        CARDIO, OLYMPIC_WEIGHTLIFTING, PLYOMETRICS, POWERLIFTING, STRENGTH, STRETCHING, STRONGMAN
    }
}
