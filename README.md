# Spring Boot Fitness Workout Tracking API
This Spring Boot application demonstrates a simple fitness workout tracking system with CRUD functionality, utilizing an H2 in-memory database for data persistence. This README provides instructions on setting up and running the application, as well as connecting to the H2 database console for data verification and testing.

## Getting Started
These instructions will guide you through setting up and running the application on your local machine.

### Prerequisites
Ensure you have the following installed:

- JDK 11 or newer
- Maven
- Your favorite IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Setup and Run

1. **Clone the repository**

   Open your terminal and run:

   ```bash
   git clone https://github.com/ranitraj/Spring-FitnessTracker.git
   cd Spring-FitnessTracker
   ```

2. **Build the project**

   Using Maven:

   ```bash
   mvn clean install
   ```

3. **Run the application**

   Execute the following command:

   ```bash
   mvn spring-boot:run
   ```

   The application will start and be accessible at `http://localhost:8080/workouts`.

### Accessing the H2 Database Console

The H2 database console is enabled by default and can be accessed through your web browser for direct database interactions:

1. Navigate to `http://localhost:8080/h2-console` in your browser.
2. Use the following settings to connect:
   - JDBC URL: `jdbc:h2:mem:booking_db`
   - User Name: `sa`
   - Password: (leave this blank)
3. Click **Connect** to access the database console.

## Testing API Endpoints

You can test the API endpoints using Postman or any other API testing tool by sending requests to `http://localhost:8080/bookings`. Below are sample requests for each available endpoint.

### Create a New Workout

- **Method:** POST
- **URL:** `/workouts`
- **Body:**

```json
{
   "workoutDate": "2024-05-06 00:00:00",
   "workoutType": "Cardio",
   "durationMinutes": 30,
   "caloriesBurned": 325.6
}
  ```

### Retrieve All Workouts

- **Method:** GET
- **URL:** `/workouts`

### Retrieve a Workout by ID

- **Method:** GET
- **URL:** `/workouts/{id}`

### Update a Workout

- **Method:** PUT
- **URL:** `/workouts/{id}`
- **Body:** (Modify as needed)

  ```json
  {
    "workoutDate": "2024-05-06 00:00:00",
    "workoutType": "Legs",
    "durationMinutes": 45,
    "caloriesBurned": 572.6
  }
  ```

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [H2 Database](https://www.h2database.com/html/main.html) - In-memory database for development and testing
- [Maven](https://maven.apache.org/) - Dependency Management
