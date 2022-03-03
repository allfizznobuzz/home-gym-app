package com.sealsugar.gymapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

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
            generator = "workout_sequence"
    )
    @Column(
            name = "muscle_ID",
            updatable = false
    )
    private Long muscleId;

    @Column(
            name = "muscle_name",
            updatable = false
    )
    private String muscleName;

    @ManyToMany(mappedBy = "secondaryWorkoutMuscles")
    Set<Workout> muscles;
}
