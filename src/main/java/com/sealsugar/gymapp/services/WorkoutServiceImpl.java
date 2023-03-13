package com.sealsugar.gymapp.services;

import com.sealsugar.gymapp.exceptions.ErrorDetail;
import com.sealsugar.gymapp.exceptions.InternalFailureException;
import com.sealsugar.gymapp.exceptions.NotFoundException;
import com.sealsugar.gymapp.models.SearchProductCriteria;
import com.sealsugar.gymapp.entities.Workout;
import com.sealsugar.gymapp.dtos.WorkoutDTO;
import com.sealsugar.gymapp.repositories.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
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

    ModelMapper modelMapper;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, ModelMapper modelMapper) {
        this.workoutRepository = workoutRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public WorkoutDTO getWorkout(Long workoutId) {
        Optional<Workout> workoutOptional;

        try {
            workoutOptional = workoutRepository.findById(workoutId);
        } catch (DataAccessException e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_ID", workoutId.toString()).detail("ERROR", "DATA_ACCESS_EXCEPTION").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        } catch (Exception e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("UNKNOWN_FAILURE").detail("WORKOUT_ID", workoutId.toString()).detail("ERROR", "UNEXPECTED_ERROR").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        }

        if(workoutOptional.isEmpty()) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("WORKOUT_NOT_FOUND").detail("WORKOUT_ID", workoutId.toString()).detail("ERROR", "NOT_FOUND_EXCEPTION").build();
            throw NotFoundException.builder().errorDetail(errorDetail).build();
        }

        return convertToDTO(workoutOptional.get());
    }

    @Override
    public List<WorkoutDTO> getAllWorkouts(SearchProductCriteria searchProductCriteria) {
        Pageable requestedPageable = PageRequest.of(searchProductCriteria.getPage(), searchProductCriteria.getElements());
        searchProductCriteria.upperCaseProductCriteria();
        List<WorkoutDTO> workoutList = new ArrayList<>();
        List<Workout> entityList;

        try {
            entityList = workoutRepository.getAllWorkouts(
                    searchProductCriteria.getWorkoutName(),
                    searchProductCriteria.getWorkoutLevel(),
                    searchProductCriteria.getPrimaryWorkoutMuscleGroup(),
                    searchProductCriteria.getSecondaryWorkoutMuscleGroups(),
                    searchProductCriteria.getExerciseType(),
                    searchProductCriteria.getEquipmentRequired(),
                    searchProductCriteria.getMechanicsType(),
                    requestedPageable
            );
        } catch (DataAccessException e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_NAME", searchProductCriteria.getWorkoutName()).detail("ERROR", "DATA_ACCESS_EXCEPTION").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        } catch (Exception e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_NAME", searchProductCriteria.getWorkoutName()).detail("ERROR", "UNEXPECTED_ERROR").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        }

        for(Workout workout : entityList) {
            workoutList.add(convertToDTO(workout));
        }

        return workoutList;
    }

    @Override
    public void saveWorkout(WorkoutDTO workoutDTO) {
        try {
            workoutRepository.save(convertToEntity(workoutDTO));
        } catch (DataAccessException e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_NAME", workoutDTO.getDescription()).detail("ERROR", "DATA_ACCESS_EXCEPTION").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        } catch (Exception e) {
            ErrorDetail errorDetail = ErrorDetail.builder().code("DATABASE_CONNECTION_FAILURE").detail("WORKOUT_NAME", workoutDTO.getDescription()).detail("ERROR", "UNEXPECTED_ERROR").build();
            throw InternalFailureException.builder().errorDetail(errorDetail).cause(e).build();
        }
    }

    private WorkoutDTO convertToDTO(Workout workout) {
        return modelMapper.map(workout, WorkoutDTO.class);
    }

    private Workout convertToEntity(WorkoutDTO workoutDTO) {
        return modelMapper.map(workoutDTO, Workout.class);
    }
}
