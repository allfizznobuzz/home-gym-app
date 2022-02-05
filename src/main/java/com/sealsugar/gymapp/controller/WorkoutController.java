package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.service.ServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {

    ServiceInterface serviceInterface;

    public WorkoutController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @GetMapping(path = "/workout/{workoutId}")
    public Workout getWorkoutByWorkoutId(@PathVariable Long workoutId) {
        return serviceInterface.getWorkoutByWorkoutId(workoutId);
    }

    @GetMapping(path = "/workouts")
    public List<Workout> getAllWorkouts() {
        return serviceInterface.getAllWorkouts();
    }

    @PostMapping(path = "/new-workouts")
    public void saveWorkouts(List<Workout> workouts) {
        serviceInterface.saveWorkouts(workouts);
    }
}
