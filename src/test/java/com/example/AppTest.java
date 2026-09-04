package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void greetShouldReturnPersonalizedMessage() {
        assertEquals("Hello, AI!", App.greet("AI"));
    }

    @Test
    void greetShouldHandleEmptyName() {
        assertEquals("Hello, !", App.greet(""));
    }
}
