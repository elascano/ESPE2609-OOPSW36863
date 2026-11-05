package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Juan Alvarez, MosQ, @ESPE
 */
public class VolumeOfCylinderTest {
    
    public VolumeOfCylinderTest() {
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

    @Test
    public void testComputeVolume_NegativeRadio() { 
        System.out.println("computeVolume");
        float radio = -3.0F;
        float height = 5.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 0.0F; 
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_NegativeHeight() { 
        System.out.println("computeVolume");
        float radio = 2.5F;
        float height = -4.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 0.0F; 
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_ZeroRadio() { 
        System.out.println("computeVolume");
        float radio = 0.0F;
        float height = 5.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = -1.0F; 
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_ZeroHeight() { 
        System.out.println("computeVolume");
        float radio = 3.0F;
        float height = 0.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = -1.0F; 
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_BothNegative() { // PASA
        System.out.println("computeVolume");
        float radio = -1.5F;
        float height = -2.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = -14.14F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_StandardIntegers() { // PASA
        System.out.println("computeVolume");
        float radio = 3.0F;
        float height = 5.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 141.37F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_CommonDecimals() { // PASA
        System.out.println("computeVolume");
        float radio = 2.5F;
        float height = 4.2F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 82.47F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_SmallRadioLargeHeight() { // PASA
        System.out.println("computeVolume");
        float radio = 0.5F;
        float height = 10.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 7.85F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_DecimalRadio() { // PASA
        System.out.println("computeVolume");
        float radio = 3.33F;
        float height = 2.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 69.67F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testComputeVolume_RoundingLimit() { // PASA
        System.out.println("computeVolume");
        float radio = 1.5F;
        float height = 3.0F;
        VolumeOfCylinder instance = new VolumeOfCylinder();
        float expResult = 21.21F;
        float result = instance.computeVolume(radio, height);
        assertEquals(expResult, result, 0);
    }
    
}
