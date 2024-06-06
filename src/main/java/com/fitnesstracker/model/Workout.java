package com.fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    @Id
    @SequenceGenerator(
            name = "workout_sequence",
            sequenceName = "workout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_sequence"
    )
    private long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date workoutDate;
    @NotNull(message = "Workout type cannot be null")
    private String workoutType;
    @Min(value = 1, message = "Duration must be greater than 0")
    private int durationMinutes;
    @DecimalMin(value = "0.0", inclusive = false, message = "Calories burned must be greater than 0.0")
    private int caloriesBurned;
}
