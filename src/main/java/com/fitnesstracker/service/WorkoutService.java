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

    /**
     * Saves or updates a workout session in the database.
     * This method handles both the creation of a new workout session and the updating of an existing one.
     * If the workout session has an ID, it updates the existing entry; otherwise, it creates a new workout session.
     *
     * @param workout the workout entity to be saved or updated.
     * @return the saved or updated workout entity with its ID populated.
     */
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    /**
     * Retrieves a workout by its ID. Throws a ResourceNotFoundException if the workout is not found.
     * @param id The ID of the workout to retrieve.
     * @return The found workout.
     * @throws ResourceNotFoundException if no workout is found with the provided ID.
     */
    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workout not found with ID: " + id)
                );
    }

    /**
     * Retrieves all workouts from the database.
     * @return A list of workouts or an empty list if no workouts are found.
     */
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
}
