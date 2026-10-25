
package ec.edu.espe.basicoperation.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ConeTest {
    
    public ConeTest() {
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
     * Test of computeVolume method, of class Cone.
     */
    @Test
    public void testComputeVolume() {
        System.out.println("computeVolume");
        float radio = 0.0F;
        float height = 0.0F;
        Cone instance = new Cone();
        float expResult = 0.0F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume1() {
        System.out.println("computeVolume");
        float radio = 3;
        float height = 4;
        Cone instance = new Cone();
        float expResult = 37.69F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume2() {
        System.out.println("computeVolume");
        float radio = -4;
        float height = -6;
        Cone instance = new Cone();
        float expResult = 0;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume3() {
        System.out.println("computeVolume");
        float radio = 5;
        float height = 0.0F;
        Cone instance = new Cone();
        float expResult = 0.0F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume4() {
        System.out.println("computeVolume");
        float radio = 0.5F;
        float height = 0.1F;
        Cone instance = new Cone();
        float expResult = 0.02F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume5() {
        System.out.println("computeVolume");
        float radio = -5;//negative radio
        float height = 2;
        Cone instance = new Cone();
        float expResult = 0.0F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume6() {
        System.out.println("computeVolume");
        float radio = 0.2F;
        float height = 100;
        Cone instance = new Cone();
        float expResult = 4.18F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume7() {
        System.out.println("computeVolume");
        float radio = 2;
        float height = 3;
        Cone instance = new Cone();
        float expResult = 12.56f ;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume8() {
        System.out.println("computeVolume");
        float radio = 1F;
        float height = 1F;
        Cone instance = new Cone();
        float expResult = 1.04F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void testComputeVolume9() {
        System.out.println("computeVolume");
        float radio = 5F;
        float height = -2F;// negative Heigth
        Cone instance = new Cone();
        float expResult = 0.0F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
}
