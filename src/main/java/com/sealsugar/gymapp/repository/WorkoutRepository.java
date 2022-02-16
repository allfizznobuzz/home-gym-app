package com.sealsugar.gymapp.repository;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {

    Iterable<Workout> findWorkoutByWorkoutNameContainsIgnoreCaseOrderByPrimaryWorkoutMuscleGroup(String workoutName);
}
