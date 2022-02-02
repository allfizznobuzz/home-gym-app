package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    public Workout getWorkoutByWorkoutId(Long workoutId) {
        Workout workout;
        try {
            Optional<Workout> workoutOptional = workoutRepository.findById(workoutId);
            workout = (workoutOptional.orElse(null));
        }
        catch (Exception e) {
            log.info("Error while getting Workout from database. Workout ID : {} Exception: {}", workoutId, e);
            throw e;
        }
        return workout;
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> workoutList = new ArrayList<>();
        try {
            Iterable<Workout> workoutIterable = workoutRepository.findAll();
            workoutIterable.forEach(workoutList::add);
        }
        catch (Exception e) {
            log.info("Error while getting Workouts from database. Exception: " + e);
            throw e;
        }
        return workoutList;
    }
}
