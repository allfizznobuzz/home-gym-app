package com.sealsugar.gymapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "muscle_and_workout_joiner")
public class MuscleAndWorkoutJoiner {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_details_ID", referencedColumnName = "workout_details_ID")
    private Muscle muscle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_details_ID", referencedColumnName = "workout_details_ID")
    private Workout;
}
