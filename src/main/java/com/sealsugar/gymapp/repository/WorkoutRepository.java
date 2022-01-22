package com.sealsugar.gymapp.repository;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkoutRepository extends CrudRepository<Workout, String> {
    Optional<Workout> findByWorkoutId(String workoutId);
}
