package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.exceptions.ErrorDetail;
import com.sealsugar.gymapp.exceptions.NotFoundException;
import com.sealsugar.gymapp.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutControllerImpl implements WorkoutController{

    WorkoutService workoutService;

    public WorkoutControllerImpl(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    public Workout getWorkoutByWorkoutId(@PathVariable String workoutName) {
        return workoutService.getWorkout(workoutName);
    }

    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @Override
    public void testException() {
        ErrorDetail errorDetail = new ErrorDetail();

        errorDetail.setCode("Code");
        errorDetail.setDescription("Description");

        throw new NotFoundException();
    }
}
