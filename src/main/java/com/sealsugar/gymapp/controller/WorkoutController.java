package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @RequestMapping(path = "/workout/{workoutId}", method = RequestMethod.GET)
    public Workout getWorkoutByWorkoutId(@PathVariable String workoutId) {
        return workoutService.getWorkoutByWorkoutId(workoutId);
    }
}
