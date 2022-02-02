package com.sealsugar.gymapp.controller;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.entity.WorkoutDetails;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import com.sealsugar.gymapp.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkoutController {

    WorkoutService workoutService;
    WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutService workoutService, WorkoutRepository workoutRepository) {
        this.workoutService = workoutService;
        this.workoutRepository = workoutRepository;
    }

    @GetMapping(path = "/workout/{workoutId}")
    public Workout getWorkoutByWorkoutId(@PathVariable Long workoutId) {

        return workoutService.getWorkoutByWorkoutId(workoutId);
    }

    @GetMapping(path = "/workout/run")
    public void run() {

        WorkoutDetails workoutDetails = new WorkoutDetails();

        workoutDetails.setDescription("Lay flat on a bench and push the barbell straight away from your chest.");
        workoutDetails.setReps(12);
        workoutDetails.setSets(3);
        workoutDetails.setEquipmentRequired("Bench, barbell,plates");
        workoutDetails.setWorkoutDuration(30);
        workoutDetails.setTimeBetweenSets(2);
        workoutDetails.setWorkoutExampleVideoUrl("musclebuilder.com/bench-press");

        Workout workout = new Workout();

        workout.setWorkoutName("Bench Press");
        workout.setWorkoutLevel("Medium");
        workout.setPrimaryWorkoutMuscleGroup("Chest");
        workout.setSecondaryWorkoutMuscleGroups("Arms");
        workout.setExerciseType("Strength");
        workout.setWorkoutDetails(workoutDetails);

        workoutRepository.save(workout);
    }
}
