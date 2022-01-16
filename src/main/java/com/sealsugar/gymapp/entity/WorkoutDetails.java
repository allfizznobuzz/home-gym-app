package com.sealsugar.gymapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity(name = "workout_details")
@Table(name = "workout_details")
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
