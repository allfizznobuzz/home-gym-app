package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkoutController {

    @GetMapping(path = "/workout/{workoutName}")
    List<Workout> getWorkout(@PathVariable String workoutName);

    @GetMapping(path = "/workout/{workoutEquipment}")
    List<Workout> getWorkout(@PathVariable List<String> workoutEquipment);

    @GetMapping(path = "/workouts")
    List<Workout> getAllWorkouts();

    @GetMapping(path = "/exception")
    void testException();
}
