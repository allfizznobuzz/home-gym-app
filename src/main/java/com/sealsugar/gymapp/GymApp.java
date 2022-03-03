package com.sealsugar.gymapp;

import com.sealsugar.gymapp.entity.Muscle;
import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.entity.WorkoutDetails;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GymApp {

    public static void main(String[] args) {
        SpringApplication.run(GymApp.class, args);
    }

    @Bean
    public CommandLineRunner startupData(final WorkoutRepository workoutRepository) {
        return args -> {

            Muscle chest = new Muscle();

            chest.setMuscleName("Chest");

            Muscle arms = new Muscle();

            arms.setMuscleName("Arms");

            WorkoutDetails workoutDetails = new WorkoutDetails();

            workoutDetails.setDescription("Lay flat on a bench and push the barbell straight away from your chest.");
            workoutDetails.setReps(12);
            workoutDetails.setSets(3);
            workoutDetails.setWorkoutDuration(30);
            workoutDetails.setTimeBetweenSets(2);
            workoutDetails.setWorkoutExampleVideoUrl("musclebuilder.com/bench-press");

            Workout workout = new Workout();
            Set<Muscle> secondaryMuscles = new HashSet<>();
            secondaryMuscles.add(arms);

            workout.setWorkoutName("Bench Press");
            workout.setWorkoutLevel("Medium");
            workout.setPrimaryWorkoutMuscle(chest);
            workout.setSecondaryWorkoutMuscles(secondaryMuscles);
            workout.setExerciseType("Strength");
            workout.setEquipmentRequired("bench, barbell, plates");
            workout.setWorkoutDetails(workoutDetails);

            WorkoutDetails workoutDetails1 = new WorkoutDetails();

            workoutDetails1.setDescription("This is a test.");
            workoutDetails1.setReps(10);
            workoutDetails1.setSets(4);
            workoutDetails1.setWorkoutDuration(30);
            workoutDetails1.setTimeBetweenSets(2);
            workoutDetails1.setWorkoutExampleVideoUrl("musclebuilder.com/test");

            Workout workout1 = new Workout();

            workout1.setWorkoutName("Shoulder Press");
            workout1.setWorkoutLevel("Hard");
            workout1.setExerciseType("Strength");
            workout1.setEquipmentRequired("barbell, plates");
            workout1.setWorkoutDetails(workoutDetails1);

            workoutRepository.save(workout);
            workoutRepository.save(workout1);
        };
    }
}
