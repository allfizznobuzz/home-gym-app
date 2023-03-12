package com.sealsugar.gymapp.services;

import com.sealsugar.gymapp.models.SearchProductCriteria;
import com.sealsugar.gymapp.entities.Workout;
import com.sealsugar.gymapp.models.WorkoutDTO;

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
    WorkoutDTO getWorkout(Long workoutId);

    /**
     * Returns a list of all workouts in the database.
     * @return List of workouts.
     */
    List<WorkoutDTO> getAllWorkouts(SearchProductCriteria searchProductCriteria);

    /**
     * Saves a list of workouts to the database.
     * @param workoutDTO
     */
    void saveWorkout(WorkoutDTO workoutDTO);
}
