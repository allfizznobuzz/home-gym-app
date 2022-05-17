package com.sealsugar.gymapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "workout_session")
public class WorkoutSession {

    @Id
    @SequenceGenerator(
            name = "workout_session_sequence",
            sequenceName = "workout_session_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "workout_session_sequence"
    )
    @Column(
            name = "workout_session_ID",
            updatable = false
    )
    private Long workoutSessionId;

    @Column(
            name = "workout_session_name"
    )
    private String workoutSessionName;

    @ManyToMany(mappedBy = "workoutSession")
    private Set<Workout> workouts;
}
