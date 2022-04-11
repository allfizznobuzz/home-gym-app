package com.sealsugar.gymapp.service;

import com.sealsugar.gymapp.model.ProductCriteria;
import com.sealsugar.gymapp.entity.Workout;
import com.sealsugar.gymapp.repository.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        Workout workout = null;
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

    @Override
    public List<Workout> getAllWorkouts(ProductCriteria productCriteria) {
        List<Workout> workoutList = new ArrayList<>();
        Pageable requestedPageable = PageRequest.of(productCriteria.getPage(), productCriteria.getElements());
        productCriteria.makeAllStringsUpperCase();

//
//        try {
//            Iterable<Workout> workoutIterable = workoutRepository.getAllWorkouts(
//                    productCriteria.getWorkoutName(),
//                    productCriteria.getWorkoutLevel(),
//                    productCriteria.getPrimaryWorkoutMuscleGroup(),
//                    productCriteria.getSecondaryWorkoutMuscleGroups(),
//                    productCriteria.getExerciseType(),
//                    productCriteria.getEquipmentRequire(),
//                    requestedPageable
//            );
//            workoutIterable.forEach(workoutList::add);
//        }
//        catch (Exception e) {
//            log.info("Error while getting Workouts from database. Exception: " + e);
//            throw e;
//        }

        return workoutList;
    }

    @Override
    public void saveWorkouts(List<Workout> workouts) {

    }
}
