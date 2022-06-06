package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.model.SearchProductCriteria;
import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.model.WorkoutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface WorkoutController {

    /**
     *
     * @param workoutId
     * @return
     */
    @GetMapping(path = "/workout/{workoutId}")
    Workout getWorkout(@PathVariable Long workoutId);

    /**
     *
     * @param searchProductCriteria
     * @return
     */
    @GetMapping(path = "/workouts")
    List<Workout> getAllWorkouts(@Valid SearchProductCriteria searchProductCriteria);

    /**
     *
     * @param workoutDTO
     */
    @GetMapping(path = "/save/workout")
    void saveWorkout(WorkoutDTO workoutDTO);
}
