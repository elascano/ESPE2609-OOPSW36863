
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private List<OrderDetail> orderDetails;
    private double discount;
    private Tax tax;
    private Packaging packaging;

    public Order() {
        this.orderDetails = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if (orderDetail == null) {
            throw new IllegalArgumentException(
                    "El detalle del pedido no puede ser nulo."
            );
        }

        orderDetails.add(orderDetail);
    }

    public boolean removeOrderDetail(OrderDetail orderDetail) {
        return orderDetails.remove(orderDetail);
    }

    public double calculateOrderSubtotal() {
        double subtotal = 0.0;

        for (OrderDetail detail : orderDetails) {
            subtotal += detail.calculateTotal();
        }

        return subtotal;
    }

    public double calculateOrderTotal() {
        double subtotalAfterDiscount = Math.max(
                0.0, calculateOrderSubtotal() - discount
        );

        double taxAmount = tax == null
                ? 0.0
                : tax.calculateTax(subtotalAfterDiscount);

        return subtotalAfterDiscount
                + taxAmount
                + addPackagingTotalCost();
    }

    public int calculateTotalItemsSold() {
        int totalItems = 0;

        for (OrderDetail detail : orderDetails) {
            totalItems += detail.getQuantity();
        }

        return totalItems;
    }

    public double addTaxTotal() {
        if (tax == null) {
            return 0.0;
        }

        double taxableAmount = Math.max(
                0.0, calculateOrderSubtotal() - discount
        );

        return tax.calculateTax(taxableAmount);
    }

    public double applyDiscount() {
        return discount;
    }

    public double addPackagingTotalCost() {
        if (packaging == null) {
            return 0.0;
        }

        return packaging.calculateAdditionalPackagingCost();
    }

    public List<OrderDetail> getOrderDetails() {
        return Collections.unmodifiableList(orderDetails);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (!Double.isFinite(discount)
                || discount < 0
                || discount > calculateOrderSubtotal()) {
            throw new IllegalArgumentException(
                    "El descuento debe ser válido y estar entre cero y el subtotal."
            );
        }

        this.discount = discount;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }
}
