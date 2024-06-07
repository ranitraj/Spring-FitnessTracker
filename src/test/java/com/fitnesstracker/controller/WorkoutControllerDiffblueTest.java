package com.fitnesstracker.controller;

import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitnesstracker.model.Workout;
import com.fitnesstracker.service.WorkoutService;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {WorkoutController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class WorkoutControllerDiffblueTest {
  @Autowired
  private WorkoutController workoutController;

  @MockBean
  private WorkoutService workoutService;

  /**
   * Method under test: {@link WorkoutController#getWorkoutById(Long)}
   */
  @Test
  void testGetWorkoutById() throws Exception {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    when(workoutService.getWorkoutById(Mockito.<Long>any())).thenReturn(workout);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/workouts/{id}", 1L);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(workoutController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"id\":1,\"workoutDate\":\"1970-01-01 00:00:00\",\"workoutType\":\"Workout Type\",\"durationMinutes\":1,"
                    + "\"caloriesBurned\":10.0}"));
  }

  /**
   * Method under test: {@link WorkoutController#addWorkout(Workout)}
   */
  @Test
  void testAddWorkout() throws Exception {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    when(workoutService.saveWorkout(Mockito.<Workout>any())).thenReturn(workout);

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");
    String content = (new ObjectMapper()).writeValueAsString(workout2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/workouts")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(workoutController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"id\":1,\"workoutDate\":\"1970-01-01 00:00:00\",\"workoutType\":\"Workout Type\",\"durationMinutes\":1,"
                    + "\"caloriesBurned\":10.0}"));
  }

  /**
   * Method under test: {@link WorkoutController#getAllWorkouts()}
   */
  @Test
  void testGetAllWorkouts() throws Exception {
    // Arrange
    when(workoutService.getAllWorkouts()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/workouts");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(workoutController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link WorkoutController#updateWorkout(Long, Workout)}
   */
  @Test
  void testUpdateWorkout() throws Exception {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    Optional<Workout> ofResult = Optional.of(workout);
    when(workoutService.updateWorkout(Mockito.<Long>any(), Mockito.<Workout>any())).thenReturn(ofResult);

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");
    String content = (new ObjectMapper()).writeValueAsString(workout2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/workouts/{id}", 1L)
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(workoutController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"id\":1,\"workoutDate\":\"1970-01-01 00:00:00\",\"workoutType\":\"Workout Type\",\"durationMinutes\":1,"
                    + "\"caloriesBurned\":10.0}"));
  }
}
