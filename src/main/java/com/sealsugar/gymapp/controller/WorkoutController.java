package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkoutController {

    @GetMapping(path = "/workout/{workoutId}")
    Workout getWorkout(@PathVariable Long workoutId);

    @GetMapping(path = "/workouts/{page}/{elements}")
    List<Workout> getAllWorkouts(@PathVariable int page, @PathVariable int elements);

    @GetMapping(path = "/exception")
    void testException();
}
