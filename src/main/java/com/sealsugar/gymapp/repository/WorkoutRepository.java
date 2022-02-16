package com.sealsugar.gymapp.repository;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends PagingAndSortingRepository<Workout, Long> {

    Iterable<Workout> findWorkoutByWorkoutNameContainsIgnoreCaseOrderByPrimaryWorkoutMuscleGroup(String workoutName);
}
