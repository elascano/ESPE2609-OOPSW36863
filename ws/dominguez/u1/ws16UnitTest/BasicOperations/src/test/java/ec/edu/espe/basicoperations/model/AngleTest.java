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
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class AngleTest {
    
    public AngleTest() {
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
     * Test of centralAngle method, of class Angle.
     */
    @Test
    public void testCentralAngle1() {
        System.out.println("centralAngle");
        int side = 0;
        Angle instance = new Angle();
        float expResult = 0.0F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @
    Test
    public void testCentralAngle2() {
        System.out.println("centralAngle");
        int side = 1;
        Angle instance = new Angle();
        float expResult = 360.0F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle3() {
        System.out.println("centralAngle");
        int side = -5;
        Angle instance = new Angle();
        float expResult = 0;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle4() {
        System.out.println("centralAngle");
        int side = 360;
        Angle instance = new Angle();
        float expResult = 1.0F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle5() {
        System.out.println("centralAngle");
        int side = 7;
        Angle instance = new Angle();
        float expResult = 51.43F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle6() {
        System.out.println("centralAngle");
        int side = 45;
        Angle instance = new Angle();
        float expResult = 8.0F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle7() {
        System.out.println("centralAngle");
        int side = -12;
        Angle instance = new Angle();
        float expResult = 0.0F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle8() {
        System.out.println("centralAngle");
        int side = 27;
        Angle instance = new Angle();
        float expResult = 13.33F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle9() {
        System.out.println("centralAngle");
        int side = 11;
        Angle instance = new Angle();
        float expResult = 32.73F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testCentralAngle10() {
        System.out.println("centralAngle");
        int side = -10;
        Angle instance = new Angle();
        float expResult = 0.0F;
        float result = instance.centralAngle(side);
        assertEquals(expResult, result, 0);
    }
}
