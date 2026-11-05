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
 * @author Asus
 */
public class ForceTest {
    
    public ForceTest() {
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
     * Test of force method, of class Force.
     */
    @Test
    public void testForce() {
        System.out.println("force");
        float mass = 0.0F;
        float aceleration = 0.0F;
        Force instance = new Force();
        float expResult = 0.0F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_PositiveIntegerValues() {
        System.out.println("force");
        float mass = 10.0F;
        float aceleration = 5.0F;
        Force instance = new Force();
        float expResult = 50.0F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_DecimalAcceleration() {
        System.out.println("force");
        float mass = 6.0F;
        float aceleration = 1.5F;
        Force instance = new Force();
        float expResult = 9.0F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_NegativeAcceleration() {
        System.out.println("force");
        float mass = 12.0F;
        float aceleration = -0.0F;
        Force instance = new Force();
        float expResult = -0.0F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_DecimalMass() {
        System.out.println("force");
        float mass = 2.5F;
        float aceleration = 4.0F;
        Force instance = new Force();
        float expResult = 10.0F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_NegativeMass() {
        System.out.println("force");
        float mass = -10.0F;
        float aceleration = 5.0F;
        Force instance = new Force();
        float expResult = -50.0F; 
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_NegativeIntegerValues() {
        System.out.println("force");
        float mass = -4.0F;
        float aceleration = -2.61F;
        Force instance = new Force();
        float expResult = 8.0F; //mass cannot be negative
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testForce_IndeterminateInput() {
        System.out.println("force");
        float mass = 10.0F;
        float aceleration = Float.NaN;
        Force instance = new Force();
        float result = instance.force(mass, aceleration);
        assertTrue(Float.isNaN(result));
    }
    
    @Test
    public void testForce_SmallScake() {
        float mass = 4.0e-20F;
        float aceleration = 2.0e-15F;
        Force instance = new Force();
        float expResult = 8.0e-35F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 1.0e-38f);
    }
    
    @Test
    public void testForce_ObjetoPequeño() {
        float mass = 0.2F;
        float aceleration = 3.5F;
        Force instance = new Force();
        float expResult = 0.7F;
        float result = instance.force(mass, aceleration);
        assertEquals(expResult, result, 0.0f);
    }
}
