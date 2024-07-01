package com.example.gymnastic.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginControllerTest {
	@Mock
    private Logger log;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
  
    }
    
    @Test
    public void testIrse() {
        String viewName = loginController.irse();
        assertEquals("index", viewName);
        verify(log, times(1)).info("irse");
    }

    @Test
    public void testDaerror() {
        String viewName = loginController.daerror();
        assertEquals("loginError", viewName);
        verify(log, times(1)).info("daerror");
    }

    @Test
    public void testVenirse() {
        String viewName = loginController.venirse();
        assertEquals("login", viewName);
        verify(log, times(1)).info("venirse");
    }
}
