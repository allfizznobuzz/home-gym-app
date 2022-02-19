package com.sealsugar.gymapp.repository;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends PagingAndSortingRepository<Workout, Long> {

    @Query(
            value = "SELECT u FROM Workout u " +
            "WHERE u.workoutName LIKE ?1 " +
            "AND u.workoutLevel LIKE ?2 " +
            "AND u.primaryWorkoutMuscleGroup LIKE ?3 " +
            "AND u.secondaryWorkoutMuscleGroups LIKE ?4 " +
            "AND u.exerciseType LIKE ?5 " +
            "AND u.equipmentRequired LIKE ?6 "
    )
    Iterable<Workout> getAllWorkouts(
//            Pageable pageable,
            @Param("workout_name") String workoutName,
            @Param("workout_level") String workoutLevel,
            @Param("primary_workout_muscle_group") String primaryWorkoutMuscleGroup,
            @Param("secondary_workout_muscle_groups") String secondaryWorkoutMuscleGroups,
            @Param("exercise_type") String exerciseType,
            @Param("equipment_required") String equipmentRequired
    );
}
