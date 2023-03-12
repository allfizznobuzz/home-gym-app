package com.sealsugar.gymapp.controllers;

import com.sealsugar.gymapp.models.SearchProductCriteria;
import com.sealsugar.gymapp.models.WorkoutDTO;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface WorkoutController {

    /**
     *
     * @param workoutId
     * @return
     */
    WorkoutDTO getWorkout(@PathVariable Long workoutId);

    /**
     *
     * @param searchProductCriteria
     * @return
     */
    List<WorkoutDTO> getAllWorkouts(@Valid SearchProductCriteria searchProductCriteria);

    /**
     *
     * @param workoutDTO
     */
    void saveWorkout(WorkoutDTO workoutDTO);
}
