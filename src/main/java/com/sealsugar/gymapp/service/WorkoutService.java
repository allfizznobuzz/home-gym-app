package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.entity.Workout;

import java.util.List;

/**
 * This defines the contract
 */
public interface WorkoutService {

    /**
     * This returns a workout by workoutName
     * @param workoutName
     * @return This returns a workout
     */
    Workout getWorkout(String workoutName);

    List<Workout> getAllWorkouts();

    void saveWorkouts(List<Workout> workouts);
}
