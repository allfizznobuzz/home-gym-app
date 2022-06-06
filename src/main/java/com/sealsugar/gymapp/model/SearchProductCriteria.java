package com.sealsugar.gymapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.util.*;

@Getter
@Setter
public class SearchProductCriteria {

    @Min(0)
    private int page = 0;
    @Min(1)
    private int elements = 50;
    private String workoutName = "";
    private String workoutLevel = "";
    private Set<String> primaryWorkoutMuscleGroup = new HashSet<>();
    private Set<String> secondaryWorkoutMuscleGroups = new HashSet<>();
    private String exerciseType = "";
    private Set<String> equipmentRequired = new HashSet<>();
    private String mechanicsType = "";

    public void upperCaseProductCriteria() {
        workoutName = workoutName.toUpperCase(Locale.ROOT);
        workoutLevel = workoutLevel.toUpperCase(Locale.ROOT);
        primaryWorkoutMuscleGroup = upperCaseList(primaryWorkoutMuscleGroup);
        secondaryWorkoutMuscleGroups = upperCaseList(secondaryWorkoutMuscleGroups);
        exerciseType = exerciseType.toUpperCase(Locale.ROOT);
        equipmentRequired = upperCaseList(equipmentRequired);
        mechanicsType = mechanicsType.toUpperCase(Locale.ROOT);
    }

    public Set<String> upperCaseList(Set<String> set) {
        if (set.isEmpty()) return new HashSet<>(List.of(""));

        Set<String> newSet = new HashSet<>();

        for (String string : set) {
            newSet.add(string.toUpperCase(Locale.ROOT));
        }

        return newSet;
    }
}
