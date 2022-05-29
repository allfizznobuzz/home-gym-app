package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.model.ProductCriteria;
import com.sealsugar.gymapp.entity.Workout;

import java.sql.SQLException;
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
    List<Workout> getAllWorkouts(ProductCriteria productCriteria);

    /**
     * Saves a list of workouts to the database.
     * @param workouts List of workouts.
     */
    void saveWorkouts(List<Workout> workouts);
}
