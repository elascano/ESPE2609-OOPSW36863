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
 * @author Dennis Noboa, 404 Founders, @ESPE
 */
public class SquareTest {
    
    public SquareTest() {
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
     * Test of computeAreaPentagon method, of class Square.
     */
    @Test
    public void testComputeAreaPentagon_GoodStandardValues() {
        float perimeter = 25.0f;
        float apothem = 3.44f;
        Square instance = new Square();
        float expResult = 43.0f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 0.01f);
    }

    @Test
    public void testComputeAreaPentagon_GoodPreciseDecimals() {
        float perimeter = 15.5f;
        float apothem = 2.0f;
        Square instance = new Square();
        float expResult = 15.5f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testComputeAreaPentagon_GoodSmallPentagon() {
        float perimeter = 5.0f;
        float apothem = 0.688f;
        Square instance = new Square();
        float expResult = 1.72f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 0.01f);
    }

    @Test
    public void testComputeAreaPentagon_StrongZeroValues() {
        float perimeter = 0.0f;
        float apothem = 0.0f;
        Square instance = new Square();
        float expResult = 0.0f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 0.0f);
    }

    @Test
    public void testComputeAreaPentagon_StrongCloseToZero() {
        float perimeter = 0.0001f;
        float apothem = 0.0001f;
        Square instance = new Square();
        float expResult = 0.000000005f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 0.000000001f);
    }

    @Test
    public void testComputeAreaPentagon_StrongFloatLimit() {
        float perimeter = Float.MAX_VALUE;
        float apothem = 1.0f;
        Square instance = new Square();
        float expResult = Float.MAX_VALUE / 2.0f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 1e30f);
    }

    @Test
    public void testComputeAreaPentagon_StrongDivisionPrecision() {
        float perimeter = 10.0f / 3.0f;
        float apothem = 2.0f;
        Square instance = new Square();
        float expResult = 3.3333333f;
        float result = instance.computeAreaPentagon(perimeter, apothem);
        assertEquals(expResult, result, 0.0001f);
    }

    @Test
    public void testComputeAreaPentagon_BadNegativePerimeter() {
        float perimeter = -25.0f;
        float apothem = 3.44f;
        Square instance = new Square();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.computeAreaPentagon(perimeter, apothem);
        });
    }

    @Test
    public void testComputeAreaPentagon_BadNegativeApothem() {
        float perimeter = 25.0f;
        float apothem = -3.44f;
        Square instance = new Square();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.computeAreaPentagon(perimeter, apothem);
        });
    }

    @Test
    public void testComputeAreaPentagon_BadBothNegative() {
        float perimeter = -10.0f;
        float apothem = -2.0f;
        Square instance = new Square();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.computeAreaPentagon(perimeter, apothem);
        });
    }
}
