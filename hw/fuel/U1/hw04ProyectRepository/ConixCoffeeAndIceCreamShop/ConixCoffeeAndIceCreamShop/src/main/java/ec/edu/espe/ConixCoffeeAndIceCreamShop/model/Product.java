/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

/**
 *
 * @author Isabel Espinosa, EsFuGa
 */
public class Product {

    private int id;
    private String name;
    private float sellingPrice;
    private float cost;

    public Product(int id, String name, float sellingPrice, float cost) {
        this.id = id;
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.cost = cost;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name
                + ", sellingPrice=" + sellingPrice + '}';
    }

    public float calculateFinalPrice() {
        return sellingPrice;
    }

    public float calculateProfit() {
        return sellingPrice - cost;
    }

    public float calculateProfitMargin() {
        if (sellingPrice <= 0) {
            return 0.0f;
        }

        return (calculateProfit() / sellingPrice) * 100;
    }
}