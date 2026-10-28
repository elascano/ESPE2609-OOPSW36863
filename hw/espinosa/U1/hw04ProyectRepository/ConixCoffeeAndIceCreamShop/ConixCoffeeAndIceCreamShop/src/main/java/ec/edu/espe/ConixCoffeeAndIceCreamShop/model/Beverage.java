package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

/**
 *
 * @author Isabel Espinosa, EsFuGa
 */
public class Beverage extends Product {

    private char size;
    private boolean temperature;

    public Beverage(char size, boolean temperature, int id, String name,
            float sellingPrice, float cost) {
        super(id, name, sellingPrice, cost);
        this.size = size;
        this.temperature = temperature;
    }

    public Beverage(char size, boolean temperature) {
        super();
        this.size = size;
        this.temperature = temperature;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public boolean isTemperature() {
        return temperature;
    }

    public void setTemperature(boolean temperature) {
        this.temperature = temperature;
    }

    public double calculatePriceBySize() {
        if (size == 'M' || size == 'm') {
            return getSellingPrice() + 0.50;
        } else if (size == 'L' || size == 'l') {
            return getSellingPrice() + 1.00;
        }

        return getSellingPrice();
    }

    public float calculatePreparationCost() {
        return getCost();
    }
}
