

package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class EulerBucklingTest {

    public EulerBucklingTest() {
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
     * Test of calculateCriticalLoad method, of class EulerBuckling.
     */
    
     /**
     * Test Case 01 - Standard Steel Column
     */
    @Test
    public void testStandardSteelColumn() {
        System.out.println("Standard Steel Column");

        double elasticModulus = 200E9;
        double momentOfInertia = 0.000008;
        double lengthFactor = 1.0;
        double columnLength = 3.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = 1754596.34;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test Case 02 - Short Steel Column
     */
    @Test
    public void testShortSteelColumn() {
        System.out.println("Short Steel Column");

        double elasticModulus = 210E9;
        double momentOfInertia = 0.000005;
        double lengthFactor = 1.0;
        double columnLength = 2.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = 2590771.16;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test Case 03 - Aluminum Column
     */
    @Test
    public void testAluminumColumn() {
        System.out.println("Aluminum Column");

        double elasticModulus = 70E9;
        double momentOfInertia = 0.000003;
        double lengthFactor = 1.0;
        double columnLength = 1.5;

        EulerBuckling instance = new EulerBuckling();

        double expResult = 921163.08;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test Case 04 - Zero Column Length
     */
    @Test
    public void testZeroColumnLength() {
        System.out.println("Zero Column Length");

        double elasticModulus = 200E9;
        double momentOfInertia = 0.000008;
        double lengthFactor = 1.0;
        double columnLength = 0.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = Double.NaN;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0);
    }

    /**
     * Test Case 05 - Negative Elastic Modulus
     */
    @Test
    public void testNegativeElasticModulus() {
        System.out.println("Negative Elastic Modulus");

        double elasticModulus = -200E9;
        double momentOfInertia = 0.000008;
        double lengthFactor = 1.0;
        double columnLength = 3.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = Double.NaN;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0);
    }
    
    
    
    /**
     * Test Case 06 - Fixed-Fixed Column
     */
    @Test
    public void testFixedFixedColumn() {
        System.out.println("Fixed-Fixed Column");

        double elasticModulus = 200E9;
        double momentOfInertia = 0.000008;
        double lengthFactor = 0.5;
        double columnLength = 3.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = 7018385.35;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test Case 07 - Long Steel Column
     */
    @Test
    public void testLongSteelColumn() {
        System.out.println("Long Steel Column");

        double elasticModulus = 200E9;
        double momentOfInertia = 0.000008;
        double lengthFactor = 1.0;
        double columnLength = 6.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = 438649.08;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test Case 08 - Zero Moment of Inertia
     */
    @Test
    public void testZeroMomentOfInertia() {
        System.out.println("Zero Moment of Inertia");

        double elasticModulus = 200E9;
        double momentOfInertia = 0.0;
        double lengthFactor = 1.0;
        double columnLength = 3.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = Double.NaN;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0);
    }

    /**
     * Test Case 09 - Negative Length Factor
     */
    @Test
    public void testNegativeLengthFactor() {
        System.out.println("Negative Length Factor");

        double elasticModulus = 200E9;
        double momentOfInertia = 0.000008;
        double lengthFactor = -1.0;
        double columnLength = 3.0;

        EulerBuckling instance = new EulerBuckling();

        double expResult = Double.NaN;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0);
    }

    /**
     * Test Case 10 - Decimal Precision Test
     */
    @Test
    public void testDecimalPrecision() {
        System.out.println("Decimal Precision Test");

        double elasticModulus = 205E9;
        double momentOfInertia = 0.0000075;
        double lengthFactor = 0.7;
        double columnLength = 2.75;

        EulerBuckling instance = new EulerBuckling();

        double expResult = 4094995.25;
        double result = instance.calculateCriticalLoad(
                elasticModulus, momentOfInertia,
                lengthFactor, columnLength);

        assertEquals(expResult, result, 0.01);
    }


}
