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
            value =
            "SELECT u, e, l, r, t, p, s FROM Workout u " +
            "JOIN u.exerciseType e " +
            "JOIN u.workoutLevel l " +
            "JOIN u.equipmentRequired r " +
            "JOIN u.mechanics t " +
            "JOIN u.primaryWorkoutMuscles p " +
            "JOIN u.secondaryWorkoutMuscles s " +
            "WHERE UPPER(u.workoutName) LIKE %?1% " +
            "AND UPPER(l.level) LIKE %?2% " +
            "AND UPPER(p.muscleName) LIKE %?3% " +
            "AND UPPER(s.muscleName) LIKE %?4% " +
            "AND UPPER(e.type) LIKE %?5% " +
            "AND UPPER(r.equipment) LIKE %?6% " +
            "AND UPPER(t.mechanicsType) LIKE %?7% "
    )
    List<Workout> getAllWorkouts(
            @Param("workout_name") String workoutName,
            @Param("level") String workoutLevel,
            @Param("muscle_name") String primaryWorkoutMuscleGroup,
            @Param("muscle_name") String secondaryWorkoutMuscleGroups,
            @Param("type") String exerciseType,
            @Param("equipment") String equipmentRequired,
            @Param("mechanics_type") String mechanicsType,
            Pageable pageable
    );
}
