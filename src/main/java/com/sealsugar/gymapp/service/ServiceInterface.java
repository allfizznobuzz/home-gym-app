package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceInterface {

    Workout getWorkoutByWorkoutId(Long workoutId);

    List<Workout> getAllWorkouts();

    void saveWorkouts(List<Workout> workouts);
}
