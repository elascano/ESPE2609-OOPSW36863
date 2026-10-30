
package ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Order;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.OrderDetail;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderJsonManager {

    private final Path filePath;
    private final Gson gson;
    private final Type orderListType;

    public OrderJsonManager() {
        filePath = Paths.get("data", "orders.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        orderListType = new TypeToken<ArrayList<OrderData>>() {}.getType();
    }

    public void saveOrders(List<Order> orders) throws IOException {

        if (orders == null) {
            throw new IllegalArgumentException(
                    "Orders list cannot be null.");
        }

        List<OrderData> data = new ArrayList<>();

        for (Order order : orders) {
            OrderData orderData = new OrderData();
            orderData.fromOrder(order);
            data.add(orderData);
        }

        Files.createDirectories(filePath.getParent());

        Files.writeString(
                filePath,
                gson.toJson(data),
                StandardCharsets.UTF_8
        );
    }

    public List<Order> loadOrders(List<Product> products)
            throws IOException {

        if (products == null) {
            throw new IllegalArgumentException(
                    "Products list cannot be null.");
        }

        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }

        String json = Files.readString(
                filePath, StandardCharsets.UTF_8);

        try {
            List<OrderData> data =
                    gson.fromJson(json, orderListType);

            List<Order> orders = new ArrayList<>();

            if (data == null) {
                return orders;
            }

            Map<Integer, Product> productsById = new HashMap<>();

            for (Product product : products) {
                productsById.put(product.getId(), product);
            }

            for (OrderData orderData : data) {
                orders.add(orderData.toOrder(productsById));
            }

            return orders;

        } catch (RuntimeException e) {
            throw new IOException(
                    "Could not read orders.json.", e);
        }
    }

    private class OrderData {

        private List<OrderDetailData> details = new ArrayList<>();
        private double discount;

        private void fromOrder(Order order) {

            if (order == null) {
                throw new IllegalArgumentException(
                        "An order cannot be null.");
            }

            discount = order.getDiscount();

            for (OrderDetail detail : order.getOrderDetails()) {
                OrderDetailData detailData = new OrderDetailData();
                detailData.fromDetail(detail);
                details.add(detailData);
            }
        }

        private Order toOrder(Map<Integer, Product> productsById) {

            Order order = new Order();

            for (OrderDetailData detailData : details) {

                Product product =
                        productsById.get(detailData.productId);

                if (product == null) {
                    throw new IllegalArgumentException(
                            "Product ID " + detailData.productId
                            + " was not found while loading orders.");
                }

                OrderDetail detail = new OrderDetail(
                        product,
                        detailData.quantity,
                        detailData.unitPrice
                );

                detail.setDiscountPercentage(
                        detailData.discountPercentage);

                order.addOrderDetail(detail);
            }

            if (discount > 0) {
                order.setDiscount(discount);
            }

            return order;
        }
    }

    private class OrderDetailData {

        private int productId;
        private int quantity;
        private float unitPrice;
        private double discountPercentage;

        private void fromDetail(OrderDetail detail) {

            if (detail == null) {
                throw new IllegalArgumentException(
                        "Order detail cannot be null.");
            }

            productId = detail.getProduct().getId();
            quantity = detail.getQuantity();
            unitPrice = detail.getUnitPrice();
            discountPercentage = detail.getDiscountPercentage();
        }
    }
}
