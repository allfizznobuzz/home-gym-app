package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.Model.ProductCriteria;
import com.sealsugar.gymapp.entity.Workout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface WorkoutController {

    @GetMapping(path = "/workout/{workoutId}")
    Workout getWorkout(@PathVariable Long workoutId);

    @GetMapping(path = "/workouts")
    List<Workout> getAllWorkouts(@Valid ProductCriteria productCriteria);

    @GetMapping(path = "/exception")
    void testException();
}
