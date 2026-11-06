package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class DistanceBetweenPointsTest {
    
    public DistanceBetweenPointsTest() {
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
     * Test of computeDistanceBetweenPoints method, of class DistanceBetweenPoints.
     */
    @Test
    public void computeDistanceTest1() {
        System.out.println("computeDistanceBetweenPoints");
        float x1 = 0.0F;
        float x2 = 0.0F;
        float y1 = 0.0F;
        float y2 = 0.0F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 0.0F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest2Positives() {
        System.out.println("Test with positive numbers");
        float x1 = 4.0F;
        float x2 = 3.0F;
        float y1 = 7.0F;
        float y2 = 2.0F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 5.1F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest3Negatives() {
        System.out.println("Test with negative numbers");
        float x1 = -4.0F;
        float x2 = -3.0F;
        float y1 = -7.0F;
        float y2 = -2.0F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 5.1F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest4Ints() {
        System.out.println("Test with negative and positive numbers");
        float x1 = -4.0F;
        float x2 = 3.0F;
        float y1 = -7.0F;
        float y2 = 2.0F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 11.4F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest5Reals() {
        System.out.println("Test with negative and positive decimal numbers");
        float x1 = -4.6F;
        float x2 = 3.2F;
        float y1 = -7.9F;
        float y2 = 2.1F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 12.68F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest6SmallData() {
        System.out.println("Test with very smalls numbers");
        float x1 = 0.000000000002F;
        float x2 = 3.2F;
        float y1 = 0.00000000005F;
        float y2 = 2.1F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 3.83F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest7BigData() {
        System.out.println("Test with very big numbers");
        float x1 = 500000000000.3F;
        float x2 = 3.2F;
        float y1 = 81234211234532.12F;
        float y2 = 2.1F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 8.1235436E9F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    
    @Test
    public void computeDistanceTest8Characters() {
        System.out.println("Test with characters");
        float x1 = 3.0F;
        float x2 = 3.0F;
        float y1 = 5.0F;
        float y2 = 5.0F;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 0.0F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest9InfiniteDecimals() {
        System.out.println("Test with infinite decimals");
        float x1 = (float) Math.sqrt(2.0);
        float x2 = 1.0F;
        float y1 = 2.0F;
        float y2 = (float) Math.PI;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 1.21F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
    
    @Test
    public void computeDistanceTest10MixedDatas() {
        System.out.println("Test with every data");
        float x1 = (float) Math.sqrt(2.0);
        float x2 = -1000000.0F;
        float y1 = 0.000002F;
        float y2 = (float) Math.PI;
        DistanceBetweenPoints instance = new DistanceBetweenPoints();
        float expResult = 1000001.44F;
        float result = instance.computeDistanceBetweenPoints(x1, x2, y1, y2);
        assertEquals(expResult, result, 0);
    }
}

