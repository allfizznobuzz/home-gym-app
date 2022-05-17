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
@Table(name = "workout_level")
public class WorkoutLevel {

    @Id
    @SequenceGenerator(
            name = "workout_level_sequence",
            sequenceName = "workout_level_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "workout_level_sequence"
    )
    @Column(
            name = "workout_level_ID",
            updatable = false
    )
    private long workoutLevelId;

    @Column(
            name = "level",
            columnDefinition = "varchar(255)"
    )
    private String level;

    public enum Level {
        BEGINNER, INTERMEDIATE, EXPERT
    }
}
