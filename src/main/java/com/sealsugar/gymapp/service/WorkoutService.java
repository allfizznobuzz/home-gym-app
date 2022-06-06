package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.model.SearchProductCriteria;
import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.model.WorkoutDTO;

import java.util.List;

/**
 * This defines the contract with WorkoutServiceImpl.java.
 */
public interface WorkoutService {

    /**
     * Returns a list of workouts that contain a given string.
     * @param
     * @return List of workouts.
     */
    Workout getWorkout(Long workoutId);

    /**
     * Returns a list of all workouts in the database.
     * @return List of workouts.
     */
    List<Workout> getAllWorkouts(SearchProductCriteria searchProductCriteria);

    /**
     * Saves a list of workouts to the database.
     * @param workoutDTO
     */
    void saveWorkout(WorkoutDTO workoutDTO);
}
