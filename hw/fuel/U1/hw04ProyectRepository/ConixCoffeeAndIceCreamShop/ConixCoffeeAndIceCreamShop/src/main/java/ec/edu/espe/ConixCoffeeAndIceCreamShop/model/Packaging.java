
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

public class Packaging {

    private String packagingType;
    private double unitCost;
    private int quantity;

    public Packaging(String packagingType, double unitCost, int quantity) {
        setPackagingType(packagingType);
        setUnitCost(unitCost);
        setQuantity(quantity);
    }

    public double calculateAdditionalPackagingCost() {
        return unitCost * quantity;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        if (packagingType == null || packagingType.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de empaque no puede estar vacío."
            );
        }

        this.packagingType = packagingType.trim();
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        if (!Double.isFinite(unitCost) || unitCost < 0) {
            throw new IllegalArgumentException(
                    "El costo unitario debe ser válido y no negativo."
            );
        }

        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "La cantidad no puede ser negativa."
            );
        }

        this.quantity = quantity;
    }
}
