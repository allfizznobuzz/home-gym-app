package com.sealsugar.gymapp.entity;


import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "workout")
@Table(name = "workout")
public class Workout {

    @Id
    @SequenceGenerator(
            name = "workout_sequence",
            sequenceName = "workout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "workout_sequence"
    )
    @Column(
            name = "workout_ID",
            updatable = false
    )
    private Long workoutId;

    @Column(
            name = "workout_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String workoutName;

    @OneToOne
    @JoinColumn(name = "workout_details_ID")
    private WorkoutDetails workoutDetails;

    @Column(
            name = "workout_level",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String workoutLevel;

    @Column(
            name = "primary_workout_muscle_group",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String primaryWorkoutMuscleGroup;

    @Column(
            name = "secondary_workout_muscle_groups",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String secondaryWorkoutMuscleGroups;

    @Column(
            name = "exercise_type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String exerciseType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Workout workout = (Workout) o;
        return workoutId != null && Objects.equals(workoutId, workout.workoutId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
