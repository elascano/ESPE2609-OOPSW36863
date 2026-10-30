package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Packaging;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackagingTest {

    @Test
    public void testCalculateCostCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 3);

        assertEquals(1.50,
                packaging.calculateAdditionalPackagingCost(), 0.001);
    }

    @Test
    public void testCalculateCostCase2() {
        Packaging packaging = new Packaging("Caja", 2.00, 3);

        assertEquals(6.00,
                packaging.calculateAdditionalPackagingCost(), 0.001);
    }

    @Test
    public void testCalculateCostCase3() {
        Packaging packaging = new Packaging("Vaso", 1.50, 0);

        assertEquals(0.00,
                packaging.calculateAdditionalPackagingCost(), 0.001);
    }


    @Test
    public void testGetPackagingTypeCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);

        assertEquals("Bolsa", packaging.getPackagingType());
    }

    @Test
    public void testGetPackagingTypeCase2() {
        Packaging packaging = new Packaging("Caja", 1.00, 2);

        assertEquals("Caja", packaging.getPackagingType());
    }

    @Test
    public void testGetPackagingTypeCase3() {
        Packaging packaging = new Packaging("  Vaso  ", 0.25, 1);

        assertEquals("Vaso", packaging.getPackagingType());
    }


    @Test
    public void testSetPackagingTypeCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);
        packaging.setPackagingType("Caja");

        assertEquals("Caja", packaging.getPackagingType());
    }

    @Test
    public void testSetPackagingTypeCase2() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);
        packaging.setPackagingType("  Vaso  ");

        assertEquals("Vaso", packaging.getPackagingType());
    }

    @Test
    public void testSetPackagingTypeCase3() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);

        packaging.setPackagingType("");
    }


    @Test
    public void testGetUnitCostCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);

        assertEquals(0.50, packaging.getUnitCost(), 0.001);
    }

    @Test
    public void testGetUnitCostCase2() {
        Packaging packaging = new Packaging("Caja", 2.00, 1);

        assertEquals(2.00, packaging.getUnitCost(), 0.001);
    }

    @Test
    public void testGetUnitCostCase3() {
        Packaging packaging = new Packaging("Vaso", 0.00, 1);

        assertEquals(0.00, packaging.getUnitCost(), 0.001);
    }


    @Test
    public void testSetUnitCostCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);
        packaging.setUnitCost(1.25);

        assertEquals(1.25, packaging.getUnitCost(), 0.001);
    }

    @Test
    public void testSetUnitCostCase2() {
        Packaging packaging = new Packaging("Caja", 2.00, 1);
        packaging.setUnitCost(0.00);

        assertEquals(0.00, packaging.getUnitCost(), 0.001);
    }

    @Test
    public void testSetUnitCostCase3() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 1);

        packaging.setUnitCost(-1.00);
    }

    @Test
    public void testGetQuantityCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 5);

        assertEquals(5, packaging.getQuantity());
    }

    @Test
    public void testGetQuantityCase2() {
        Packaging packaging = new Packaging("Caja", 1.00, 10);

        assertEquals(10, packaging.getQuantity());
    }

    @Test
    public void testGetQuantityCase3() {
        Packaging packaging = new Packaging("Vaso", 0.25, 0);

        assertEquals(0, packaging.getQuantity());
    }

    @Test
    public void testSetQuantityCase1() {
        Packaging packaging = new Packaging("Bolsa", 0.50, 2);
        packaging.setQuantity(5);

        assertEquals(5, packaging.getQuantity());
    }

    @Test
    public void testSetQuantityCase2() {
        Packaging packaging = new Packaging("Caja", 1.00, 10);
        packaging.setQuantity(0);

        assertEquals(0, packaging.getQuantity());
    }

    @Test
    public void testSetQuantityCase3() {
        Packaging packaging = new Packaging("Vaso", 0.25, 2);

        packaging.setQuantity(-1);
    }
}
