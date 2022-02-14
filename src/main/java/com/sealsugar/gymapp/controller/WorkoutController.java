package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkoutController {

    @GetMapping(path = "/workout/{workoutName}")
    public Workout getWorkoutByWorkoutId(@PathVariable String workoutName);

    @GetMapping(path = "/workouts")
    public List<Workout> getAllWorkouts();

    @GetMapping(path = "/exception")
    public void testException();
}
