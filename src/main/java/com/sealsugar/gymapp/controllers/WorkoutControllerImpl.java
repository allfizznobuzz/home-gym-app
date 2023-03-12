package com.sealsugar.gymapp.controllers;

import com.sealsugar.gymapp.models.SearchProductCriteria;
import com.sealsugar.gymapp.entities.Workout;
import com.sealsugar.gymapp.models.WorkoutDTO;
import com.sealsugar.gymapp.services.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutControllerImpl implements WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutControllerImpl(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @Override
    @GetMapping(path = "/workout/{workoutId}")
    public WorkoutDTO getWorkout(@PathVariable Long workoutId) {
        return workoutService.getWorkout(workoutId);
    }

    @Override
    @GetMapping(path = "/workouts")
    public List<WorkoutDTO> getAllWorkouts(SearchProductCriteria searchProductCriteria) {
        return workoutService.getAllWorkouts(searchProductCriteria);
    }

    @Override
    @GetMapping(path = "/save/workout")
    public void saveWorkout(WorkoutDTO workoutDTO) {
        workoutService.saveWorkout(workoutDTO);
    }
}
