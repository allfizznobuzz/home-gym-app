package com.sealsugar.gymapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Data
@Entity(name = "Workout")
public class Workout {

    @Id
    @SequenceGenerator(
            name = "workout_sequence",
            sequenceName = "workout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "workout_sequence"
    )
    @Column(
            name = "workout_id",
            updatable = false
    )
    private Long workoutId;
    private String workoutName;
    private WorkoutDetails workoutDetails;
    private String workoutLevel;
    private String primaryWorkoutMuscleGroup;
    private List<String> secondaryWorkoutMuscleGroups;
    private String exerciseType;
}
