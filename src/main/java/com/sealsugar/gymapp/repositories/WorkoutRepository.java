package com.sealsugar.gymapp.repositories;

import com.sealsugar.gymapp.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query(
            value =
            "SELECT DISTINCT u FROM Workout u " +
            "JOIN u.equipmentRequired r " +
            "JOIN u.primaryWorkoutMuscles p " +
            "JOIN u.secondaryWorkoutMuscles s " +
            "WHERE UPPER(u.workoutName) LIKE %?1% " +
            "OR UPPER(u.workoutLevel.level) LIKE %?2% " +
            "OR UPPER(p.muscleName) IN ?3 " +
            "OR UPPER(s.muscleName) IN ?4 " +
            "OR UPPER(u.exerciseType.type) LIKE %?5% " +
            "OR UPPER(r.equipment) IN ?6 " +
            "OR UPPER(u.mechanics.mechanicsType) LIKE %?7% "
    )
    List<Workout> getAllWorkouts(
            @Param("workout_name") String workoutName,
            @Param("level") String workoutLevel,
            @Param("muscle_name") Set<String> primaryWorkoutMuscleGroup,
            @Param("muscle_name") Set<String> secondaryWorkoutMuscleGroups,
            @Param("type") String exerciseType,
            @Param("equipment") Set<String> equipmentRequired,
            @Param("mechanics_type") String mechanicsType,
            Pageable pageable
    );
}
