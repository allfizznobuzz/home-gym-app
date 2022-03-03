package com.sealsugar.gymapp.entity;

import lombok.*;
import org.springframework.data.util.ProxyUtils;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
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
            nullable = false
    )
    private String workoutName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_details_ID", referencedColumnName = "workout_details_ID")
    private WorkoutDetails workoutDetails;

    @Column(
            name = "workout_level",
            nullable = false
    )
    private String workoutLevel;

    @Column(
            name = "equipment_required",
            nullable = false
    )
    private String equipmentRequired;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "muscle_ID", referencedColumnName = "muscle_ID")
    private Muscle primaryWorkoutMuscle;

    @ManyToMany
    @JoinTable(
            name = "secondary_workout_muscle",
            joinColumns = @JoinColumn(name = "workout_ID"),
            inverseJoinColumns = @JoinColumn(name = "muscle_ID")
    )
    Set<Muscle> secondaryWorkoutMuscles;

    @Column(
            name = "exercise_type",
            nullable = false
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
