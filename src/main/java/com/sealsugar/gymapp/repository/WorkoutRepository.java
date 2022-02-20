package com.sealsugar.gymapp.repository;

import com.sealsugar.gymapp.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query(
            value = "SELECT u FROM Workout u " +
            "WHERE UPPER(u.workoutName) LIKE %?1% " +
            "AND UPPER(u.workoutLevel) LIKE %?2% " +
            "AND UPPER(u.primaryWorkoutMuscleGroup) LIKE %?3% " +
            "AND UPPER(u.secondaryWorkoutMuscleGroups) LIKE %?4% " +
            "AND UPPER(u.exerciseType) LIKE %?5% " +
            "AND UPPER(u.equipmentRequired) LIKE %?6% "
    )
    List<Workout> getAllWorkouts(
            @Param("workout_name") String workoutName,
            @Param("workout_level") String workoutLevel,
            @Param("primary_workout_muscle_group") String primaryWorkoutMuscleGroup,
            @Param("secondary_workout_muscle_groups") String secondaryWorkoutMuscleGroups,
            @Param("exercise_type") String exerciseType,
            @Param("equipment_required") String equipmentRequired,
            Pageable pageable
    );
}
