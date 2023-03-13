package com.sealsugar.gymapp.dtos;

import lombok.Data;

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
    private WorkoutLevelDTO workoutLevel;
    private Set<MuscleDTO> primaryWorkoutMuscles;
    private Set<MuscleDTO> secondaryWorkoutMuscles;
    private Set<ExerciseEquipmentDTO> equipmentRequired;
}
