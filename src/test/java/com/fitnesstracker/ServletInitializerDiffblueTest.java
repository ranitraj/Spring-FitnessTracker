package com.fitnesstracker;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

class ServletInitializerDiffblueTest {
  /**
   * Method under test:
   * {@link ServletInitializer#configure(SpringApplicationBuilder)}
   */
  @Test
  void testConfigure() {
    // Arrange
    ServletInitializer servletInitializer = new ServletInitializer();
    Class<Object> forNameResult = Object.class;
    SpringApplicationBuilder application = new SpringApplicationBuilder(forNameResult);

    // Act and Assert
    assertSame(application, servletInitializer.configure(application));
  }
}
