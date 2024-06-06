package com.fitnesstracker.service;

import com.fitnesstracker.exceptions.ResourceNotFoundException;
import com.fitnesstracker.model.Workout;
import com.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * Updates the workout with the specified ID using the provided workout details.
     * This method first retrieves the existing workout by ID. If found, it updates the workout with the new details provided.
     * It then saves the updated workout using the saveWorkout method.
     *
     * @param id The ID of the workout to update.
     * @param updatedWorkoutDetails The updated workout details to apply.
     * @return An Optional containing the updated workout if found, or an empty Optional otherwise.
     */
    public Optional<Workout> updateWorkout(Long id, Workout updatedWorkoutDetails) {
        return workoutRepository.findById(id).map(existingWorkout -> {
            existingWorkout.setWorkoutDate(updatedWorkoutDetails.getWorkoutDate());
            existingWorkout.setWorkoutType(updatedWorkoutDetails.getWorkoutType());
            existingWorkout.setDurationMinutes(updatedWorkoutDetails.getDurationMinutes());
            existingWorkout.setCaloriesBurned(updatedWorkoutDetails.getCaloriesBurned());

            // Update using the saveWorkout method in Service
            return saveWorkout(existingWorkout);
        });
    }
}
