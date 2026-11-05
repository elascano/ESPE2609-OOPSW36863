
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

public class OrderDetail {

    private Product product;
    private int quantity;
    private float unitPrice;
    private float subTotal;
    private double discountPercentage;

    public OrderDetail(Product product, int quantity, float unitPrice,
            float subTotal, double discountPercentage) {
        setProduct(product);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setDiscountPercentage(discountPercentage);
        calculateSubtotal();
    }

    public OrderDetail(Product product, int quantity, float unitPrice) {
        this(product, quantity, unitPrice, 0.0f, 0.0);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(
                    "El producto no puede ser nulo."
            );
        }

        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero."
            );
        }

        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        if (!Float.isFinite(unitPrice) || unitPrice < 0) {
            throw new IllegalArgumentException(
                    "El precio unitario debe ser válido y no negativo."
            );
        }

        this.unitPrice = unitPrice;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        if (!Float.isFinite(subTotal) || subTotal < 0) {
            throw new IllegalArgumentException(
                    "El subtotal debe ser válido y no negativo."
            );
        }

        this.subTotal = subTotal;
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

    public double calculateSubtotal() {
        subTotal = unitPrice * quantity;
        return subTotal;
    }

    public double calculateDiscount() {
        return calculateSubtotal() * discountPercentage / 100.0;
    }

    public double calculateTotal() {
        return calculateSubtotal() - calculateDiscount();
    }
}
