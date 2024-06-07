package com.fitnesstracker.config;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fitnesstracker.model.Workout;
import com.fitnesstracker.repository.WorkoutRepository;
import com.fitnesstracker.service.WorkoutService;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataLoaderDiffblueTest {
  /**
   * Method under test: {@link DataLoader#initDatabase(WorkoutService)}
   */
  @Test
  void testInitDatabase() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataLoader dataLoader = new DataLoader();

    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    WorkoutRepository workoutRepository = mock(WorkoutRepository.class);
    when(workoutRepository.save(Mockito.<Workout>any())).thenReturn(workout);

    // Act
    dataLoader.initDatabase(new WorkoutService(workoutRepository)).run("Args");

    // Assert
    verify(workoutRepository, atLeast(1)).save(Mockito.<Workout>any());
  }

  /**
   * Method under test: {@link DataLoader#initDatabase(WorkoutService)}
   */
  @Test
  void testInitDatabase2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataLoader dataLoader = new DataLoader();

    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");
    WorkoutService workoutService = mock(WorkoutService.class);
    when(workoutService.saveWorkout(Mockito.<Workout>any())).thenReturn(workout);

    // Act
    dataLoader.initDatabase(workoutService).run("Args");

    // Assert
    verify(workoutService, atLeast(1)).saveWorkout(Mockito.<Workout>any());
  }
}
