package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.entity.Workout;

import java.util.List;

/**
 * This defines the contract with WorkoutServiceImpl.java.
 */
public interface WorkoutService {

    /**
     * Returns a list of workouts that contain a given string.
     * @param workoutId Long.
     * @return List of workouts.
     */
    Workout getWorkout(Long workoutId);

    /**
     * Returns a list of all workouts in the database.
     * @return List of workouts.
     */
    List<Workout> getAllWorkouts(int page, int elements);

    /**
     * Saves a list of workouts to the database.
     * @param workouts List of workouts.
     */
    void saveWorkouts(List<Workout> workouts);
}
