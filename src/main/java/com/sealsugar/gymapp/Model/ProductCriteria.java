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
    private String workoutName = "";
    private String workoutLevel = "";
    private String primaryWorkoutMuscleGroup = "";
    private String secondaryWorkoutMuscleGroups = "";
    private String exerciseType = "";
    private String equipmentRequire = "";
}
