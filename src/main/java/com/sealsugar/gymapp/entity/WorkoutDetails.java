package com.sealsugar.gymapp.entity;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "workout_details")
public class WorkoutDetails {

    @Id
    @SequenceGenerator(
            name = "workout_details_sequence",
            sequenceName = "workout_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "workout_details_sequence"
    )
    @Column(
            name = "workout_details_ID",
            updatable = false
    )
    private Long workoutDetailsId;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "sets"
    )
    private int sets;

    @Column(
            name = "reps"
    )
    private int reps;

    @Column(
            name = "time_between_sets"
    )
    private int timeBetweenSets;

    @Column(
            name = "workout_duration"
    )
    private int workoutDuration;

    @Column(
            name = "workout_example_video_url"
    )
    private String workoutExampleVideoUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        WorkoutDetails that = (WorkoutDetails) o;
        return workoutDetailsId != null && Objects.equals(workoutDetailsId, that.workoutDetailsId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
