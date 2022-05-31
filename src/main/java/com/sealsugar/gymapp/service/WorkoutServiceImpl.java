package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.exceptions.ErrorDetail;
import com.sealsugar.gymapp.exceptions.InternalFailureException;
import com.sealsugar.gymapp.model.ProductCriteria;
import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class WorkoutServiceImpl implements WorkoutService {

    WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout getWorkout(Long workoutId) {
        Optional<Workout> workoutOptional;
        Workout workout;

        try {
            workoutOptional = workoutRepository.findById(workoutId);
        } catch (DataAccessException e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_ID", workoutId.toString()).detail("ERROR", "DATA_ACCESS_EXCEPTION").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        } catch (Exception e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_ID", workoutId.toString()).detail("ERROR", "UNEXPECTED_ERROR").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        }

        workout = (workoutOptional.orElse(null));

        return workout;
    }

    @Override
    public List<Workout> getAllWorkouts(ProductCriteria productCriteria) {
        Pageable requestedPageable = PageRequest.of(productCriteria.getPage(), productCriteria.getElements());
        productCriteria.upperCaseProductCriteria();
        List<Workout> workoutList;

        try {
            workoutList = workoutRepository.getAllWorkouts(
                    productCriteria.getWorkoutName(),
                    productCriteria.getWorkoutLevel(),
                    productCriteria.getPrimaryWorkoutMuscleGroup(),
                    productCriteria.getSecondaryWorkoutMuscleGroups(),
                    productCriteria.getExerciseType(),
                    productCriteria.getEquipmentRequired(),
                    productCriteria.getMechanicsType(),
                    requestedPageable
            );
        } catch (DataAccessException e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_NAME", productCriteria.getWorkoutName()).detail("ERROR", "DATA_ACCESS_EXCEPTION").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        } catch (Exception e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_NAME", productCriteria.getWorkoutName()).detail("ERROR", "UNEXPECTED_ERROR").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        }


        return workoutList;
    }

    @Override
    public void saveWorkout(Workout workout) {
        try {
            workoutRepository.save(workout);
        } catch (DataAccessException e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_ID", workout.getWorkoutId().toString()).detail("ERROR", "DATA_ACCESS_EXCEPTION").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        } catch (Exception e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_ID", workout.getWorkoutId().toString()).detail("ERROR", "UNEXPECTED_ERROR").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        }
    }
}
