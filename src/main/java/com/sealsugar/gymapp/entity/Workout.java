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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_level_ID", referencedColumnName = "workout_level_ID")
    private WorkoutLevel workoutLevel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_equipment_ID", referencedColumnName = "exercise_equipment_ID")
    private ExerciseEquipment equipmentRequired;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_type_ID", referencedColumnName = "exercise_type_ID")
    private ExerciseType exerciseType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mechanics_ID", referencedColumnName = "mechanics_ID")
    private Mechanics mechanics;

    @ManyToMany
    @JoinTable(
            name = "primary_workout_muscles",
            joinColumns = @JoinColumn(name = "workout_ID"),
            inverseJoinColumns = @JoinColumn(name = "muscle_ID")
    )
    private Set<Muscle> primaryWorkoutMuscles;

    @ManyToMany
    @JoinTable(
            name = "secondary_workout_muscles",
            joinColumns = @JoinColumn(name = "workout_ID"),
            inverseJoinColumns = @JoinColumn(name = "muscle_ID")
    )
    private Set<Muscle> secondaryWorkoutMuscles;

    @ManyToMany
    @JoinTable(
            name = "workouts_by_session",
            joinColumns = @JoinColumn(name = "workout_ID"),
            inverseJoinColumns = @JoinColumn(name = "workout_session_ID")
    )
    private Set<WorkoutSession> workoutSession;

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
