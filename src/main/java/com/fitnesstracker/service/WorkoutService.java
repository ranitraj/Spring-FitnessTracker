package com.fitnesstracker.service;

import com.fitnesstracker.exceptions.ResourceNotFoundException;
import com.fitnesstracker.model.Workout;
import com.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout getBookingById(Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workout not found with ID: " + id)
                );
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
}
