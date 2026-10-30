
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

public class Tax {

    private double taxRate;

    public Tax(double taxRate) {
        setTaxRate(taxRate);
    }

    public double calculateTax(double amount) {
        if (!Double.isFinite(amount) || amount < 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser un número válido y no negativo."
            );
        }

        return amount * taxRate / 100.0;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        if (!Double.isFinite(taxRate) || taxRate < 0 || taxRate > 100) {
            throw new IllegalArgumentException(
                    "La tasa debe estar entre 0 y 100."
            );
        }

        this.taxRate = taxRate;
    }
}
