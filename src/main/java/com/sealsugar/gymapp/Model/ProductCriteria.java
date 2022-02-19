package com.sealsugar.gymapp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductCriteria {

    @Min(0)
    private int page = 0;
    @Min(1)
    private int elements = 50;
    @NotBlank
    private String workoutName = "";
    @NotBlank
    private String workoutLevel = "";
    @NotBlank
    private String primaryWorkoutMuscleGroup = "";
    @NotBlank
    private String secondaryWorkoutMuscleGroups = "";
    @NotBlank
    private String exerciseType = "";
    @NotBlank
    private String equipmentRequire = "";
}
