package com.sealsugar.gymapp;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.entity.WorkoutDetails;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GymApp {

    public static void main(String[] args) {
        SpringApplication.run(GymApp.class, args);
    }

    @Bean
    public CommandLineRunner startupData(final WorkoutRepository workoutRepository) {
        return args -> {

            WorkoutDetails workoutDetails = new WorkoutDetails();

            workoutDetails.setDescription("Lay flat on a bench and push the barbell straight away from your chest.");
            workoutDetails.setReps(12);
            workoutDetails.setSets(3);
            workoutDetails.setWorkoutDuration(30);
            workoutDetails.setTimeBetweenSets(2);
            workoutDetails.setWorkoutExampleVideoUrl("musclebuilder.com/bench-press");

            Workout workout = new Workout();

            workout.setWorkoutName("Bench Press");
            workout.setWorkoutLevel("Medium");
            workout.setPrimaryWorkoutMuscleGroup("Chest");
            workout.setSecondaryWorkoutMuscleGroups("Arms");
            workout.setExerciseType("Strength");
            workout.setEquipmentRequired("Bench, barbell,plates");
            workout.setWorkoutDetails(workoutDetails);

            workoutRepository.save(workout);

        };
    }
}
