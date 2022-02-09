package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {

    WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping(path = "/workout/{workoutName}")
    public Workout getWorkoutByWorkoutId(@PathVariable String workoutName) {
        return workoutService.getWorkoutByWorkoutName(workoutName);
    }

    @GetMapping(path = "/workouts")
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

}
