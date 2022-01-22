package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    public Workout getWorkoutByWorkoutId(String workoutId) {
        Workout workout = null;
        try {
            Optional<Workout> optional = workoutRepository.findByWorkoutId(workoutId);
            workout = (optional.orElse(null));
        }
        catch (Exception e) {
            log.info("Error while getting Workout from database. Workout ID : {} Exception: {}", workoutId, e);
            throw e;
        }
        return workout;
    }
}
