package com.fitnesstracker.config;

import com.fitnesstracker.model.Workout;
import com.fitnesstracker.service.WorkoutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(WorkoutService workoutService) {
        return args -> {
            workoutService.saveWorkout(
                    new Workout(
                            null,
                            initWorkoutDate(),
                            "Upper Body",
                            45,
                            345.8f
                    )
            );

            workoutService.saveWorkout(
                    new Workout(
                            null,
                            initWorkoutDate(),
                            "Legs",
                            70,
                            728.3f
                    )
            );
        };
    }

    /**
     * Initializes the workout date with the current date and time.
     * This method captures the exact moment of method execution converted to the 'Date' type.
     * The time is set to the current local time, which is formatted later according to the pattern "yyyy-MM-dd HH:mm:ss".
     *
     * @return Current date and time formatted as a 'Date' object for consistency with JSON serialization expectations.
     */
    private Date initWorkoutDate() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Convert LocalDate back to Date for matching the format in Request body
        return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
