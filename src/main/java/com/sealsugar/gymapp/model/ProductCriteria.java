package com.sealsugar.gymapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.util.Locale;

@Getter
@Setter
public class ProductCriteria {

    @Min(0)
    private int page = 0;
    @Min(1)
    private int elements = 50;
    private String workoutName = "";
    private String workoutLevel = "";
    private String primaryWorkoutMuscleGroup = "";
    private String secondaryWorkoutMuscleGroups = "";
    private String exerciseType = "";
    private String equipmentRequire = "";

    public void makeAllStringsUpperCase() {
        workoutName = workoutName.toUpperCase(Locale.ROOT);
        workoutLevel = workoutLevel.toUpperCase(Locale.ROOT);
        primaryWorkoutMuscleGroup = primaryWorkoutMuscleGroup.toUpperCase(Locale.ROOT);
        secondaryWorkoutMuscleGroups = secondaryWorkoutMuscleGroups.toUpperCase(Locale.ROOT);
        exerciseType = exerciseType.toUpperCase(Locale.ROOT);
        equipmentRequire = equipmentRequire.toUpperCase(Locale.ROOT);
    }
}
