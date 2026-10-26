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
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class RectangleTest {
    
    public RectangleTest() {
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
     * Test of computeArea method, of class Rectangle.
     */
    @Test
    public void testComputeAreaTest1() {
        System.out.println("computeArea");
        float base = 72.0F;
        float height = 198.0F;
        Rectangle instance = new Rectangle();
        float expResult = 14256.0F;
        float result = instance.computeAreaTest1(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest2() {
        System.out.println("computeArea");
        float base = -40.0F;
        float height = -55.0F;
        Rectangle instance = new Rectangle();
        float expResult = 2200.0F;
        float result = instance.computeAreaTest2(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest3() {
        System.out.println("computeArea");
        float base = 0.1F;
        float height = 0.1F;
        Rectangle instance = new Rectangle();
        float expResult = 0.01F;
        float result = instance.computeAreaTest3(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest4() {
        System.out.println("computeArea");
        float base = 1.5F;
        float height = 50.0F;
        Rectangle instance = new Rectangle();
        float expResult = 75.0F;
        float result = instance.computeAreaTest4(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest5() {
        System.out.println("computeArea");
        float base = -3.0F;
        float height = 6.0F;
        Rectangle instance = new Rectangle();
        float expResult = 18.0F;
        float result = instance.computeAreaTest5(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest6() {
        System.out.println("computeArea");
        float base = 5.0F;
        float height = -4.0F;
        Rectangle instance = new Rectangle();
        float expResult = 20.0F;
        float result = instance.computeAreaTest6(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest7() {
        System.out.println("computeArea");
        float base = 2.5F;
        float height = 4.8F;
        Rectangle instance = new Rectangle();
        float expResult = 12.0F;
        float result = instance.computeAreaTest7(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest8() {
        System.out.println("computeArea");
        float base = 3.33F;
        float height = 3.0F;
        Rectangle instance = new Rectangle();
        float expResult = 9.99F;
        float result = instance.computeAreaTest8(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest9() {
        System.out.println("computeArea");
        float base = 0.5F;
        float height = 1.80F;
        Rectangle instance = new Rectangle();
        float expResult = 0.90F;
        float result = instance.computeAreaTest9(base, height);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void testComputeAreaTest10() {
        System.out.println("computeArea");
        float base = 0.0F;
        float height = Float.POSITIVE_INFINITY;
        Rectangle instance = new Rectangle();
        float expResult = Float.NaN;
        float result = instance.computeAreaTest10(base, height);
        assertEquals(expResult, result, 0);
    }
}
