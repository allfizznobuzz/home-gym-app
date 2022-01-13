package com.sealsugar.gymapp.workouts;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class Workout {

    private int workoutId;
    private String workoutName;
    private WorkoutDetails workoutDetails;
    private String workoutLevel;
    private String primaryWorkoutMuscleGroup;
    private List<String> secondaryWorkoutMuscleGroups;
    private String exerciseType;

    public Workout(int workoutId, String workoutName, WorkoutDetails workoutDetails, String workoutLevel, String primaryWorkoutMuscleGroup, List<String> secondaryWorkoutMuscleGroups, String exerciseType) {
        this.workoutId = workoutId;
        this.workoutName = workoutName;
        this.workoutDetails = workoutDetails;
        this.workoutLevel = workoutLevel;
        this.primaryWorkoutMuscleGroup = primaryWorkoutMuscleGroup;
        this.secondaryWorkoutMuscleGroups = secondaryWorkoutMuscleGroups;
        this.exerciseType = exerciseType;
    }
}

@Getter
@Setter
@Component
class WorkoutDetails {
    private String description;
    private int sets;
    private int reps;
    private int timeBetweenSets;
    private int workoutDuration;
    private String equipmentRequired;
    private String workoutExampleVideoUrl;

    public WorkoutDetails(String description, int sets, int reps, int timeBetweenSets, int workoutDuration, String equipmentRequired, String workoutExampleVideoUrl) {
        this.description = description;
        this.sets = sets;
        this.reps = reps;
        this.timeBetweenSets = timeBetweenSets;
        this.workoutDuration = workoutDuration;
        this.equipmentRequired = equipmentRequired;
        this.workoutExampleVideoUrl = workoutExampleVideoUrl;
    }
}
