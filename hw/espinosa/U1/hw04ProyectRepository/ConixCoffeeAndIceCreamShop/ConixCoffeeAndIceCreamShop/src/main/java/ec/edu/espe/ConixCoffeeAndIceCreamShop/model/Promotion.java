
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

public class Promotion {

    private boolean valid;
    private double discountPercentage;

    public Promotion(boolean valid, double discountPercentage) {
        this.valid = valid;
        setDiscountPercentage(discountPercentage);
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public double computeDiscount(double totalAmount) {
        if (!Double.isFinite(totalAmount) || totalAmount < 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser válido y no negativo."
            );
        }

        if (!valid) {
            return 0.0;
        }

        return totalAmount * discountPercentage / 100.0;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        if (!Double.isFinite(discountPercentage)
                || discountPercentage < 0
                || discountPercentage > 100) {
            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 100."
            );
        }

        this.discountPercentage = discountPercentage;
    }
}
