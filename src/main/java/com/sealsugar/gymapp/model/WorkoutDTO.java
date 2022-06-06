package com.sealsugar.gymapp.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class WorkoutDTO {

    private String workoutName;
    private String description;
    private int reps;
    private int sets;
    private int timeBetweenSets;
    private int workoutDuration;
    private int workoutExampleUrl;
    private int exerciseTypeId;
    private int mechanicsId;
    private int workoutLevelId;
    private Set<String> primaryWorkoutMuscleGroup = new HashSet<>();
    private Set<String> secondaryWorkoutMuscleGroups = new HashSet<>();
    private Set<String> equipmentRequired = new HashSet<>();
}
