package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class ParallelogramTest {
    
    public ParallelogramTest() {
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
     * Test of ComputeArea method, of class Parallelogram.
     */
    @Test
    public void testComputeArea() {
        System.out.println("ComputeArea");
        float base = 0.0F;
        float height = 0.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = 0.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);

    }
    

    @Test
    public void testComputeArea2() {
        System.out.println("ComputeArea - valores enteros positivos");
        float base = 5.0F;
        float height = 4.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = 20.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test 3: values with decimals.
     */
    @Test
    public void testComputeArea3() {
        System.out.println("ComputeArea - valores decimales");
        float base = 3.5F;
        float height = 2.2F;
        Parallelogram instance = new Parallelogram();
        float expResult = 7.70001F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test 4: zero base and positive height.
     */
    @Test
    public void testComputeArea4() {
        System.out.println("ComputeArea - base en cero");
        float base = 0.0F;
        float height = 8.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = 0.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test 5: height at zero and positive base.
     */
    @Test
    public void testComputeArea5() {
        System.out.println("ComputeArea - altura en cero");
        float base = 12.0F;
        float height = 0.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = 0.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test 6: large values.
     */
    @Test
    public void testComputeArea6() {
        System.out.println("ComputeArea - valores grandes");
        float base = 1000.0F;
        float height = 2500.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = 2500000.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test 7: very small values.
     */
    @Test
    public void testComputeArea7() {
        System.out.println("ComputeArea - valores pequenos");
        float base = 0.5F;
        float height = 0.25F;
        Parallelogram instance = new Parallelogram();
        float expResult = 0.125F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test 8: negative base (the method does not validate; it returns a negative area).
     */
    @Test
    public void testComputeArea8() {
        System.out.println("ComputeArea - base negativa");
        float base = -5.0F;
        float height = 3.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = +15.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test 9: negative base and height (the product turns out positive).
     */
    @Test
    public void testComputeArea9() {
        System.out.println("ComputeArea - base y altura negativas");
        float base = -4.0F;
        float height = -6.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = 24.0F;
        float result = instance.ComputeArea(base, height);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test 10: commutative property (swapping the base and height yields the same area).
     */
    @Test
    public void testComputeArea10() {
        System.out.println("ComputeArea - propiedad conmutativa");
        float base = 7.5F;
        float height = 3.0F;
        Parallelogram instance = new Parallelogram();
        float expResult = instance.ComputeArea(base, height);
        float result = instance.ComputeArea(height, base);
        assertEquals(expResult, result, 0);
    }
    
}
