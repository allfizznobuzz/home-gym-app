package com.sealsugar.gymapp.models;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class WorkoutDTO {

    private Long workoutId;
    private String workoutName;
    private String description;
    private int sets;
    private int reps;
    private int timeBetweenSets;
    private int workoutDuration;
    private String workoutExampleUrl;
    private ExeciseTypeDTO exerciseType;
    private MechanicsDTO mechanics;
    private WorkoutDTO workoutLevel;
    private Set<MuscleDTO> primaryWorkoutMuscleGroup = new HashSet<>();
    private Set<MuscleDTO> secondaryWorkoutMuscleGroups = new HashSet<>();
    private Set<ExerciseEquipmentDTO> equipmentRequired = new HashSet<>();
}
