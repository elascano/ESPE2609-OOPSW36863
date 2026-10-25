
package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class physicsTest {
    
    public physicsTest() {
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
     * Test of Speedformula method, of class physics.
     */
   @Test
public void testSpeedformula0() {
    System.out.println("speedformula");
    float distance = 0.0F;
    float time = 0.0F;
    physics instance = new physics();

    assertThrows(IllegalArgumentException.class, () -> {
        instance.speedformula(distance, time);
    });
}
     @Test
    public void testSpeedformula1() {
        System.out.println("speedformula");
        float distance = 8.0F;
        float time = 2.0F;
        physics instance = new physics();
        float expResult = 4.0F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);

    }
     @Test
    public void testSpeedformula2() {
        System.out.println("speedformula");
        float distance = 12.0F;
        float time =24.0F;
        physics instance = new physics();
        float expResult = 0.5F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);

    }
     @Test
    public void testSpeedformula3() {
        System.out.println("speedformula");
        float distance = 5.0F;
        float time = 3.0F;
        physics instance = new physics();
        float expResult = 1.6F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 2);

    }
     @Test
    public void testSpeedformula4() {
        System.out.println("speedformula");
        float distance = 10.0F;
        float time = 2.0F;
        physics instance = new physics();
        float expResult = 5.0F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);

    }
     @Test
    public void testSpeedformula5() {
        System.out.println("speedformula");
        float distance = 40.0F;
        float time = 5.0F;
        physics instance = new physics();
        float expResult = 8.0F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);

    }
     @Test
    public void testSpeedformula6() {
        System.out.println("speedformula");
        float distance = 10.0F;
        float time = 10.0F;
        physics instance = new physics();
        float expResult = 1.0F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);

    }
     @Test
    public void testSpeedformula7() {
        System.out.println("speedformula");
        float distance = 9.0F;
        float time = 5.0F;
        physics instance = new physics();
        float expResult = 1.8F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);

    }
     @Test
    public void testSpeedformula8() {
        System.out.println("speedformula");
        float distance = 85.0F;
        float time = 6.0F;
        physics instance = new physics();
        float expResult = 14.1F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 2);

    }
     @Test
    public void testSpeedformula9() {
        System.out.println("speedformula");
        float distance = 810.0F;
        float time = 2.0F;
        physics instance = new physics();
        float expResult = 405.0F;
        float result = instance.speedformula(distance, time);
        assertEquals(expResult, result, 0);
 
    }
 
    
}
