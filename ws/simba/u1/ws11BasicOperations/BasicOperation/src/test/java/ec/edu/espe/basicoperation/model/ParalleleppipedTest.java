package ec.edu.espe.basicoperation.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Danilo Simba, @ESPE
 */
public class ParalleleppipedTest {
    
    public ParalleleppipedTest() {
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
     * Test of computeVolume method, of class Paralleleppiped.
     */
    @Test
    public void testComputeVolume() {
        System.out.println("computeVolume");
        float length = 2.9F;
        float width = 3.2F;
        float height = 4.7F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 43.6F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume2() {
        System.out.println("computeVolume");
        float length = 2.0F;
        float width = 2.0F;
        float height = 1.0F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 4.0F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume3() {
        System.out.println("computeVolume");
        float length = 2.5F;
        float width = 3.7F;
        float height = 4.0F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 37.0F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume4() {
        System.out.println("computeVolume");
        float length = 0.0F;
        float width = 0.0F;
        float height = 0.0F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = -24.0F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume5() {
        System.out.println("computeVolume");
        float length = 2.6F;
        float width = 2.7F;
        float height = 3.0F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 21.06F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume6() {
        System.out.println("computeVolume");
        float length = 9.0F;
        float width = 3.6F;
        float height = 2.1F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 68.04F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume7() {
        System.out.println("computeVolume");
        float length = 16.9F;
        float width = 15.2F;
        float height = 30.9F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 486.6F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume8() {
        System.out.println("computeVolume");
        float length = 3.6F;
        float width = 7.2F;
        float height = 5.1F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 132.192F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume9() {
        System.out.println("computeVolume");
        float length = 5.0F;
        float width = 6.0F;
        float height = 8.0F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 240.0F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
    @Test
    public void testComputeVolume0() {
        System.out.println("computeVolume");
        float length = 2.0F;
        float width = 2.0F;
        float height = 3.0F;
        Paralleleppiped instance = new Paralleleppiped();
        float expResult = 12.0F;
        float result = instance.computeVolume(length, width, height);
        assertEquals(expResult, result, 0);
        
    }
   
}
