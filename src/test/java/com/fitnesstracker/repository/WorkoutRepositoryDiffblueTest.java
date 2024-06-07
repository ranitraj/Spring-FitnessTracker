package com.fitnesstracker.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fitnesstracker.model.Workout;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {WorkoutRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.fitnesstracker.model"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class WorkoutRepositoryDiffblueTest {
  @Autowired
  private WorkoutRepository workoutRepository;

  /**
   * Method under test: {@link WorkoutRepository#findBy(Example, Function)}
   */
  @Test
  void testFindBy() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(0.5f);
    workout2.setDurationMinutes(0);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("com.fitnesstracker.model.Workout");
    workoutRepository.save(workout);
    workoutRepository.save(workout2);

    Workout workout3 = new Workout();
    workout3.setCaloriesBurned(10.0f);
    workout3.setDurationMinutes(1);
    workout3.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout3.setWorkoutType("Workout Type");
    Example<Workout> example = Example.of(workout3);
    Function<FluentQuery.FetchableFluentQuery<Workout>, Object> queryFunction = mock(Function.class);
    when(queryFunction.apply(Mockito.<FluentQuery.FetchableFluentQuery<Workout>>any())).thenReturn("Apply");

    // Act
    Object actualFindByResult = workoutRepository.findBy(example, queryFunction);

    // Assert
    verify(queryFunction).apply(isA(FluentQuery.FetchableFluentQuery.class));
    assertEquals("Apply", actualFindByResult);
  }

  /**
   * Method under test: {@link WorkoutRepository#findById(Object)}
   */
  @Test
  void testFindById() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(0.5f);
    workout2.setDurationMinutes(0);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("com.fitnesstracker.model.Workout");
    workoutRepository.save(workout);
    workoutRepository.save(workout2);

    Workout workout3 = new Workout();
    workout3.setCaloriesBurned(10.0f);
    workout3.setDurationMinutes(1);
    workout3.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout3.setWorkoutType("Workout Type");

    // Act and Assert
    assertTrue(workoutRepository.findById(workoutRepository.save(workout3).getId()).isPresent());
  }

  /**
   * Method under test: {@link WorkoutRepository#getById(Object)}
   */
  @Test
  void testGetById() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(0.5f);
    workout2.setDurationMinutes(0);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("com.fitnesstracker.model.Workout");
    workoutRepository.save(workout);
    workoutRepository.save(workout2);

    Workout workout3 = new Workout();
    workout3.setCaloriesBurned(10.0f);
    workout3.setDurationMinutes(1);
    workout3.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout3.setWorkoutType("Workout Type");

    // Act and Assert
    assertSame(workout3, workoutRepository.getById(workoutRepository.save(workout3).getId()));
  }

  /**
   * Method under test: {@link WorkoutRepository#getOne(Object)}
   */
  @Test
  void testGetOne() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(0.5f);
    workout2.setDurationMinutes(0);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("com.fitnesstracker.model.Workout");
    workoutRepository.save(workout);
    workoutRepository.save(workout2);

    // Act and Assert
    assertEquals(1L, workoutRepository.getOne(1L).getId().longValue());
  }

  /**
   * Method under test: {@link WorkoutRepository#getReferenceById(Object)}
   */
  @Test
  void testGetReferenceById() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(0.5f);
    workout2.setDurationMinutes(0);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("com.fitnesstracker.model.Workout");
    workoutRepository.save(workout);
    workoutRepository.save(workout2);

    Workout workout3 = new Workout();
    workout3.setCaloriesBurned(10.0f);
    workout3.setDurationMinutes(1);
    workout3.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout3.setWorkoutType("Workout Type");

    // Act and Assert
    assertSame(workout3, workoutRepository.getReferenceById(workoutRepository.save(workout3).getId()));
  }

  /**
   * Method under test: {@link WorkoutRepository#save(Object)}
   */
  @Test
  void testSave() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    // Act and Assert
    assertSame(workout, workoutRepository.save(workout));
  }

  /**
   * Method under test: {@link WorkoutRepository#saveAll(Iterable)}
   */
  @Test
  void testSaveAll() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    Workout workout3 = new Workout();
    workout3.setCaloriesBurned(10.0f);
    workout3.setDurationMinutes(1);
    workout3.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout3.setWorkoutType("Workout Type");
    List<Workout> entities = Arrays.asList(workout, workout2, workout3);

    // Act
    List<Workout> actualSaveAllResult = workoutRepository.saveAll(entities);

    // Assert
    assertEquals(3, actualSaveAllResult.size());
    assertEquals(entities, actualSaveAllResult);
    assertSame(workout3, actualSaveAllResult.get(2));
  }

  /**
   * Method under test: {@link WorkoutRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  void testSaveAllAndFlush() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    Workout workout3 = new Workout();
    workout3.setCaloriesBurned(10.0f);
    workout3.setDurationMinutes(1);
    workout3.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout3.setWorkoutType("Workout Type");
    List<Workout> entities = Arrays.asList(workout, workout2, workout3);

    // Act
    List<Workout> actualSaveAllAndFlushResult = workoutRepository.saveAllAndFlush(entities);

    // Assert
    assertEquals(3, actualSaveAllAndFlushResult.size());
    assertEquals(entities, actualSaveAllAndFlushResult);
    assertSame(workout3, actualSaveAllAndFlushResult.get(2));
  }

  /**
   * Method under test: {@link WorkoutRepository#saveAndFlush(Object)}
   */
  @Test
  void testSaveAndFlush() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    // Act and Assert
    assertSame(workout, workoutRepository.saveAndFlush(workout));
  }
}
