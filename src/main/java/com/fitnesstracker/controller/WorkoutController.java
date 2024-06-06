/*
 * Copyright 2024 the original author.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fitnesstracker.controller;

import com.fitnesstracker.exceptions.ResourceNotFoundException;
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

    /**
     * Updates an existing workout identified by the given ID with the provided workout details.
     * If the workout with the specified ID does not exist, a 404 Not Found is returned.
     *
     * @param id The ID of the workout to update.
     * @param workout The updated workout details.
     * @return ResponseEntity containing the updated workout or an error message.
     * @throws ResourceNotFoundException if no workout is found with the provided ID.
     */
    @PutMapping(ApiUrls.API_URL_UPDATE_WORKOUT)
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @Validated @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Workout not found with ID: " + id)
                );
    }
}
