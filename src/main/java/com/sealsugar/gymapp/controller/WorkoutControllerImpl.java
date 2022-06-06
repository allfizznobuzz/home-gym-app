package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.model.SearchProductCriteria;
import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.model.WorkoutDTO;
import com.sealsugar.gymapp.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutControllerImpl implements WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutControllerImpl(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @Override
    public Workout getWorkout(@PathVariable Long workoutId) {
        return workoutService.getWorkout(workoutId);
    }

    @Override
    public List<Workout> getAllWorkouts(SearchProductCriteria searchProductCriteria) {
        return workoutService.getAllWorkouts(searchProductCriteria);
    }

    @Override
    public void saveWorkout(WorkoutDTO workoutDTO) {
        workoutService.saveWorkout(workoutDTO);
    }
}
