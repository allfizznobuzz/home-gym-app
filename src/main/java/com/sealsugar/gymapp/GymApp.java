package com.sealsugar.gymapp;

import com.sealsugar.gymapp.entity.*;
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

            WorkoutLevel workoutLevel = new WorkoutLevel();
            ExerciseType exerciseType = new ExerciseType();
            ExerciseEquipment exerciseEquipment = new ExerciseEquipment();
            Mechanics mechanics = new Mechanics();
            Muscle muscle = new Muscle();
            Set<Muscle> muscles = new HashSet();

            Workout workoutOne = new Workout();
            workoutLevel.setLevel("Medium");
            exerciseType.setType("Strength");
            exerciseEquipment.setEquipment("bench, barbell, plates");
            mechanics.setMechanicsType("Compound");
            muscle.setMuscleName("Chest");
            muscle.setMuscleId(1L);
            muscles.add(muscle);

            workoutOne.setWorkoutName("Bench Press");
            workoutOne.setDescription("Sit on the bench and push a bar up");
            workoutOne.setSets(3);
            workoutOne.setReps(9);
            workoutOne.setTimeBetweenSets(60);
            workoutOne.setWorkoutDuration(30);
            workoutOne.setWorkoutExampleVideoUrl("www.test.com");
            workoutOne.setWorkoutLevel(workoutLevel);
            workoutOne.setExerciseType(exerciseType);
            workoutOne.setEquipmentRequired(exerciseEquipment);
            workoutOne.setMechanics(mechanics);
            workoutOne.setPrimaryWorkoutMuscles(muscles);
            workoutOne.setSecondaryWorkoutMuscles(muscles);
//
//            Workout workoutTwo = new Workout();
//            workoutLevel.setLevel(WorkoutLevel.Level.INTERMEDIATE);
//            exerciseType.setType(ExerciseType.Type.STRENGTH);
//            exerciseEquipment.setEquipment("barbell, plates");
//            mechanicsType.setType(MechanicsType.Type.COMPOUND);
//
//            workoutTwo.setWorkoutName("Shoulder Press");
//            workoutTwo.setDescription("Stand up and push a bar over your head");
//            workoutTwo.setWorkoutLevel(workoutLevel);
//            workoutTwo.setExerciseType(exerciseType);
//            workoutTwo.setEquipmentRequired(exerciseEquipment);
//            workoutTwo.setMechanicsType(mechanicsType);
//            workoutTwo.setPrimaryWorkoutMuscles(muscles);
//            workoutTwo.setSecondaryWorkoutMuscles(muscles);
//
            workoutRepository.save(workoutOne);
//            workoutRepository.save(workoutTwo);
        };
    }
}
