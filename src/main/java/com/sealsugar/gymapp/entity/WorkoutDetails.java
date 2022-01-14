package com.sealsugar.gymapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity (name = "workout_details")
public class WorkoutDetails {

    @Id()
    private String description;
    private int sets;
    private int reps;
    private int timeBetweenSets;
    private int workoutDuration;
    private String equipmentRequired;
    private String workoutExampleVideoUrl;
}
