/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class KineticEnergyTest {
    
    public KineticEnergyTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateKineticEnergy method, of class KineticEnergy.
     */
    @Test
    public void testCalculateKineticEnergy1() {
        System.out.println("calculateKineticEnergy1");
        double mass = 10.0;
        double velocity = 2.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 20.0;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy2() {
        System.out.println("calculateKineticEnergy2");
        double mass = 2.0;
        double velocity = 0.1;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 0.01;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy3() {
        System.out.println("calculateKineticEnergy3");
        double mass = 5.0;
        double velocity = 0.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 0.0;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy4() {
        System.out.println("calculateKineticEnergy4");
        double mass = 5.3;
        double velocity = 2.1;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 11.68;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy5() {
        System.out.println("calculateKineticEnergy5");
        double mass = 10.0;
        double velocity = 10.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 500.0;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy6() {
        System.out.println("calculateKineticEnergy6");
        double mass = 4.5;
        double velocity = 2.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 9.0;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy7() {
        System.out.println("calculateKineticEnergy7");
        double mass = -4.0;
        double velocity = 5.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 0.0;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy8() {
        System.out.println("calculateKineticEnergy8");
        double mass = 1.0;
        double velocity = 1.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 0.5;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy9() {
        System.out.println("calculateKineticEnergy9");
        double mass = 3.3;
        double velocity = 3.3;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 17.97;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testCalculateKineticEnergy10() {
        System.out.println("calculateKineticEnergy10");
        double mass = 100.0;
        double velocity = 5.0;
        KineticEnergy instance = new KineticEnergy();
        double expResult = 1250.0;
        double result = instance.calculateKineticEnergy(mass, velocity);
        assertEquals(expResult, result, 0.01);
    }
    
}