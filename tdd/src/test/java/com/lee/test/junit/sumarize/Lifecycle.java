package com.lee.test.junit.sumarize;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class Lifecycle {

    @BeforeAll
    static void initializeExternalResources() {
        System.out.println("Initializing external resources...");
    }
 
    @BeforeEach
    void initializeMockObjects() {
        System.out.println("Initializing mock objects...");
    }
 
    @Test
    void someTest() {
        System.out.println("Running some test...");
        assertTrue(true);
    }
 
    @Test
    void otherTest() {
        assumeTrue(true);
 
        System.out.println("Running another test...");
        assertNotEquals(1, 42, "Why wouldn't these be the same?");
    }
 
    @Test
    @Disabled
    void disabledTest() {
        System.exit(1);
    }
 
    @AfterEach
    void tearDown() {
        System.out.println("Tearing down...");
    }
 
    @AfterAll
    static void freeExternalResources() {
        System.out.println("Freeing external resources...");
    }
 
}