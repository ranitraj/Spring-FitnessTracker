package com.fitnesstracker.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class GlobalExceptionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link GlobalExceptionHandler#handleResourceNotFoundException(ResourceNotFoundException)}
   */
  @Test
  void testHandleResourceNotFoundException() {
    // Arrange
    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    // Act
    ResponseEntity<?> actualHandleResourceNotFoundExceptionResult = globalExceptionHandler
        .handleResourceNotFoundException(new ResourceNotFoundException("An error occurred"));

    // Assert
    assertEquals("An error occurred", actualHandleResourceNotFoundExceptionResult.getBody());
    assertEquals(404, actualHandleResourceNotFoundExceptionResult.getStatusCodeValue());
    assertTrue(actualHandleResourceNotFoundExceptionResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link GlobalExceptionHandler#handleException(Exception)}
   */
  @Test
  void testHandleException() {
    // Arrange
    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    // Act
    ResponseEntity<?> actualHandleExceptionResult = globalExceptionHandler.handleException(new Exception("foo"));

    // Assert
    assertEquals("An error occurred: foo", actualHandleExceptionResult.getBody());
    assertEquals(500, actualHandleExceptionResult.getStatusCodeValue());
    assertTrue(actualHandleExceptionResult.getHeaders().isEmpty());
  }
}
