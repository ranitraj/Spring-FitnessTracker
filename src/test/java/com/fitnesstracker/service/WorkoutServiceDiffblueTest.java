package com.fitnesstracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fitnesstracker.exceptions.ResourceNotFoundException;
import com.fitnesstracker.model.Workout;
import com.fitnesstracker.repository.WorkoutRepository;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WorkoutService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class WorkoutServiceDiffblueTest {
  @MockBean
  private WorkoutRepository workoutRepository;

  @Autowired
  private WorkoutService workoutService;

  /**
   * Method under test: {@link WorkoutService#saveWorkout(Workout)}
   */
  @Test
  void testSaveWorkout() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    when(workoutRepository.save(Mockito.<Workout>any())).thenReturn(workout);

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act
    Workout actualSaveWorkoutResult = workoutService.saveWorkout(workout2);

    // Assert
    verify(workoutRepository).save(isA(Workout.class));
    assertSame(workout, actualSaveWorkoutResult);
  }

  /**
   * Method under test: {@link WorkoutService#saveWorkout(Workout)}
   */
  @Test
  void testSaveWorkout2() {
    // Arrange
    when(workoutRepository.save(Mockito.<Workout>any())).thenThrow(new ResourceNotFoundException("An error occurred"));

    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> workoutService.saveWorkout(workout));
    verify(workoutRepository).save(isA(Workout.class));
  }

  /**
   * Method under test: {@link WorkoutService#getWorkoutById(Long)}
   */
  @Test
  void testGetWorkoutById() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    Optional<Workout> ofResult = Optional.of(workout);
    when(workoutRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    // Act
    Workout actualWorkoutById = workoutService.getWorkoutById(1L);

    // Assert
    verify(workoutRepository).findById(eq(1L));
    assertSame(workout, actualWorkoutById);
  }

  /**
   * Method under test: {@link WorkoutService#getWorkoutById(Long)}
   */
  @Test
  void testGetWorkoutById2() {
    // Arrange
    Optional<Workout> emptyResult = Optional.empty();
    when(workoutRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> workoutService.getWorkoutById(1L));
    verify(workoutRepository).findById(eq(1L));
  }

  /**
   * Method under test: {@link WorkoutService#getWorkoutById(Long)}
   */
  @Test
  void testGetWorkoutById3() {
    // Arrange
    when(workoutRepository.findById(Mockito.<Long>any())).thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> workoutService.getWorkoutById(1L));
    verify(workoutRepository).findById(eq(1L));
  }

  /**
   * Method under test: {@link WorkoutService#getAllWorkouts()}
   */
  @Test
  void testGetAllWorkouts() {
    // Arrange
    ArrayList<Workout> workoutList = new ArrayList<>();
    when(workoutRepository.findAll()).thenReturn(workoutList);

    // Act
    List<Workout> actualAllWorkouts = workoutService.getAllWorkouts();

    // Assert
    verify(workoutRepository).findAll();
    assertTrue(actualAllWorkouts.isEmpty());
    assertSame(workoutList, actualAllWorkouts);
  }

  /**
   * Method under test: {@link WorkoutService#getAllWorkouts()}
   */
  @Test
  void testGetAllWorkouts2() {
    // Arrange
    when(workoutRepository.findAll()).thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> workoutService.getAllWorkouts());
    verify(workoutRepository).findAll();
  }

  /**
   * Method under test: {@link WorkoutService#updateWorkout(Long, Workout)}
   */
  @Test
  void testUpdateWorkout() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    Optional<Workout> ofResult = Optional.of(workout);

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");
    when(workoutRepository.save(Mockito.<Workout>any())).thenReturn(workout2);
    when(workoutRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    Workout updatedWorkoutDetails = new Workout();
    updatedWorkoutDetails.setCaloriesBurned(10.0f);
    updatedWorkoutDetails.setDurationMinutes(1);
    updatedWorkoutDetails.setId(1L);
    updatedWorkoutDetails
        .setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    updatedWorkoutDetails.setWorkoutType("Workout Type");

    // Act
    Optional<Workout> actualUpdateWorkoutResult = workoutService.updateWorkout(1L, updatedWorkoutDetails);

    // Assert
    verify(workoutRepository).findById(eq(1L));
    verify(workoutRepository).save(isA(Workout.class));
    assertEquals(ofResult, actualUpdateWorkoutResult);
  }

  /**
   * Method under test: {@link WorkoutService#updateWorkout(Long, Workout)}
   */
  @Test
  void testUpdateWorkout2() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    Optional<Workout> ofResult = Optional.of(workout);
    when(workoutRepository.save(Mockito.<Workout>any())).thenThrow(new ResourceNotFoundException("An error occurred"));
    when(workoutRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

    Workout updatedWorkoutDetails = new Workout();
    updatedWorkoutDetails.setCaloriesBurned(10.0f);
    updatedWorkoutDetails.setDurationMinutes(1);
    updatedWorkoutDetails.setId(1L);
    updatedWorkoutDetails
        .setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    updatedWorkoutDetails.setWorkoutType("Workout Type");

    // Act and Assert
    assertThrows(ResourceNotFoundException.class, () -> workoutService.updateWorkout(1L, updatedWorkoutDetails));
    verify(workoutRepository).findById(eq(1L));
    verify(workoutRepository).save(isA(Workout.class));
  }

  /**
   * Method under test: {@link WorkoutService#updateWorkout(Long, Workout)}
   */
  @Test
  void testUpdateWorkout3() {
    // Arrange
    Optional<Workout> emptyResult = Optional.empty();
    when(workoutRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

    Workout updatedWorkoutDetails = new Workout();
    updatedWorkoutDetails.setCaloriesBurned(10.0f);
    updatedWorkoutDetails.setDurationMinutes(1);
    updatedWorkoutDetails.setId(1L);
    updatedWorkoutDetails
        .setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    updatedWorkoutDetails.setWorkoutType("Workout Type");

    // Act
    Optional<Workout> actualUpdateWorkoutResult = workoutService.updateWorkout(1L, updatedWorkoutDetails);

    // Assert
    verify(workoutRepository).findById(eq(1L));
    assertFalse(actualUpdateWorkoutResult.isPresent());
    assertSame(emptyResult, actualUpdateWorkoutResult);
  }
}
