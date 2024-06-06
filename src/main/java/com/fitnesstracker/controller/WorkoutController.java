package com.fitnesstracker.controller;

import com.fitnesstracker.model.Workout;
import com.fitnesstracker.service.WorkoutService;
import com.fitnesstracker.utils.ApiUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrls.API_URL_WORKOUTS)
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * Creates a new workout session in the system. If the operation is successful, returns the saved workout object.
     * In case of any exception, the global exception handler takes over and returns an appropriate error response.
     *
     * @param workout the workout details from the request body to be saved
     * @return a ResponseEntity containing the saved workout object and HTTP status code
     */

    @PostMapping
    public ResponseEntity<Workout> addWorkout(@Validated @RequestBody Workout workout) {
        Workout savedWorkout = workoutService.saveWorkout(workout);
        return ResponseEntity.ok(savedWorkout);
    }

    /**
     * Handles the HTTP GET request to retrieve a workout by its ID.
     * Returns the workout details if found, otherwise throws a ResourceNotFoundException
     * which is handled globally to return a 404 Not Found response.
     *
     * @param id The ID of the workout to retrieve.
     * @return A ResponseEntity containing the workout if found, with an HTTP 200 OK status.
     */
    @GetMapping(ApiUrls.API_URL_GET_WORKOUT_BY_ID)
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        Workout fetchedWorkout = workoutService.getWorkoutById(id);
        return ResponseEntity.ok(fetchedWorkout);
    }

    /**
     * Retrieves all workouts. Returns an empty list if no workouts are found.
     * @return ResponseEntity containing a list of workouts or an empty list with HTTP 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        List<Workout> workouts = workoutService.getAllWorkouts();
        return ResponseEntity.ok(workouts);
    }
}
