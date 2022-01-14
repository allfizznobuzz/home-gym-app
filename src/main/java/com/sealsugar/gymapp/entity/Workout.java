package com.sealsugar.gymapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "Workout")
public class Workout {

    @Id()
    private int workoutId;
    private String workoutName;
    private WorkoutDetails workoutDetails;
    private String workoutLevel;
    private String primaryWorkoutMuscleGroup;
    private List<String> secondaryWorkoutMuscleGroups;
    private String exerciseType;
}
