package com.sealsugar.gymapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@NoArgsConstructor
@Data
@Entity (name = "workout_details")
public class WorkoutDetails {

    @Column(name = "description")
    private String description;
    private int sets;
    private int reps;
    private int timeBetweenSets;
    private int workoutDuration;
    private String equipmentRequired;
    private String workoutExampleVideoUrl;
}
