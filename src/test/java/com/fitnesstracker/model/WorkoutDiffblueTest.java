package com.fitnesstracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

class WorkoutDiffblueTest {
  /**
   * Method under test: {@link Workout#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Workout()).canEqual("Other"));
    assertFalse((new Workout(1L, mock(java.sql.Date.class), "Workout Type", 3, 10.0f)).canEqual("Other"));
  }

  /**
   * Method under test: {@link Workout#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertTrue(workout.canEqual(workout2));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#equals(Object)}
   *   <li>{@link Workout#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertEquals(workout, workout2);
    int expectedHashCodeResult = workout.hashCode();
    assertEquals(expectedHashCodeResult, workout2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#equals(Object)}
   *   <li>{@link Workout#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(null);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(null);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertEquals(workout, workout2);
    int expectedHashCodeResult = workout.hashCode();
    assertEquals(expectedHashCodeResult, workout2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#equals(Object)}
   *   <li>{@link Workout#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(null);
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(null);
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertEquals(workout, workout2);
    int expectedHashCodeResult = workout.hashCode();
    assertEquals(expectedHashCodeResult, workout2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#equals(Object)}
   *   <li>{@link Workout#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType(null);

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType(null);

    // Act and Assert
    assertEquals(workout, workout2);
    int expectedHashCodeResult = workout.hashCode();
    assertEquals(expectedHashCodeResult, workout2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#equals(Object)}
   *   <li>{@link Workout#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    // Act and Assert
    assertEquals(workout, workout);
    int expectedHashCodeResult = workout.hashCode();
    assertEquals(expectedHashCodeResult, workout.hashCode());
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(0.5f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(3);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(2L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(null);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(null);
    workout.setWorkoutType("Workout Type");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType(null);

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("com.fitnesstracker.model.Workout");

    Workout workout2 = new Workout();
    workout2.setCaloriesBurned(10.0f);
    workout2.setDurationMinutes(1);
    workout2.setId(1L);
    workout2.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout2.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, workout2);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, null);
  }

  /**
   * Method under test: {@link Workout#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Workout workout = new Workout();
    workout.setCaloriesBurned(10.0f);
    workout.setDurationMinutes(1);
    workout.setId(1L);
    workout.setWorkoutDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    workout.setWorkoutType("Workout Type");

    // Act and Assert
    assertNotEquals(workout, "Different type to Workout");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#Workout()}
   *   <li>{@link Workout#setCaloriesBurned(float)}
   *   <li>{@link Workout#setDurationMinutes(int)}
   *   <li>{@link Workout#setId(Long)}
   *   <li>{@link Workout#setWorkoutDate(Date)}
   *   <li>{@link Workout#setWorkoutType(String)}
   *   <li>{@link Workout#toString()}
   *   <li>{@link Workout#getCaloriesBurned()}
   *   <li>{@link Workout#getDurationMinutes()}
   *   <li>{@link Workout#getId()}
   *   <li>{@link Workout#getWorkoutDate()}
   *   <li>{@link Workout#getWorkoutType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Workout actualWorkout = new Workout();
    actualWorkout.setCaloriesBurned(10.0f);
    actualWorkout.setDurationMinutes(1);
    actualWorkout.setId(1L);
    Date workoutDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualWorkout.setWorkoutDate(workoutDate);
    actualWorkout.setWorkoutType("Workout Type");
    actualWorkout.toString();
    float actualCaloriesBurned = actualWorkout.getCaloriesBurned();
    int actualDurationMinutes = actualWorkout.getDurationMinutes();
    Long actualId = actualWorkout.getId();
    Date actualWorkoutDate = actualWorkout.getWorkoutDate();

    // Assert that nothing has changed
    assertEquals("Workout Type", actualWorkout.getWorkoutType());
    assertEquals(1, actualDurationMinutes);
    assertEquals(10.0f, actualCaloriesBurned);
    assertEquals(1L, actualId.longValue());
    assertSame(workoutDate, actualWorkoutDate);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Workout#Workout(Long, Date, String, int, float)}
   *   <li>{@link Workout#setCaloriesBurned(float)}
   *   <li>{@link Workout#setDurationMinutes(int)}
   *   <li>{@link Workout#setId(Long)}
   *   <li>{@link Workout#setWorkoutDate(Date)}
   *   <li>{@link Workout#setWorkoutType(String)}
   *   <li>{@link Workout#toString()}
   *   <li>{@link Workout#getCaloriesBurned()}
   *   <li>{@link Workout#getDurationMinutes()}
   *   <li>{@link Workout#getId()}
   *   <li>{@link Workout#getWorkoutDate()}
   *   <li>{@link Workout#getWorkoutType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Workout actualWorkout = new Workout(1L,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), "Workout Type", 1,
        10.0f);
    actualWorkout.setCaloriesBurned(10.0f);
    actualWorkout.setDurationMinutes(1);
    actualWorkout.setId(1L);
    Date workoutDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualWorkout.setWorkoutDate(workoutDate);
    actualWorkout.setWorkoutType("Workout Type");
    actualWorkout.toString();
    float actualCaloriesBurned = actualWorkout.getCaloriesBurned();
    int actualDurationMinutes = actualWorkout.getDurationMinutes();
    Long actualId = actualWorkout.getId();
    Date actualWorkoutDate = actualWorkout.getWorkoutDate();

    // Assert that nothing has changed
    assertEquals("Workout Type", actualWorkout.getWorkoutType());
    assertEquals(1, actualDurationMinutes);
    assertEquals(10.0f, actualCaloriesBurned);
    assertEquals(1L, actualId.longValue());
    assertSame(workoutDate, actualWorkoutDate);
  }
}
