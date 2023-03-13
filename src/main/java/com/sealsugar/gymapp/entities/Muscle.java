package com.sealsugar.gymapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "muscle")
public class Muscle {

    @Id
    @SequenceGenerator(
            name = "muscle_sequence",
            sequenceName = "muscle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "muscle_sequence"
    )
    @Column(
            name = "muscle_ID",
            updatable = false
    )
    private Long muscleId;

    @Column(
            name = "muscle_name",
            columnDefinition = "varchar(255)"
    )
    private String muscleName;

//    public enum MuscleType {
//        CHEST, LOWER_CHEST, MIDDLE_CHEST, UPPER_CHEST,
//        FOREARMS, LATS, MIDDLE_BACK, LOWER_BACK, NECK,
//        QUADRICEPS, HAMSTRINGS, CALVES, TRICEPS, TRAPS,
//        SHOULDERS, ABDOMINALS, GLUTES, BICEPS, ADDUCTORS,
//        ABDUCTORS
//    }
}
