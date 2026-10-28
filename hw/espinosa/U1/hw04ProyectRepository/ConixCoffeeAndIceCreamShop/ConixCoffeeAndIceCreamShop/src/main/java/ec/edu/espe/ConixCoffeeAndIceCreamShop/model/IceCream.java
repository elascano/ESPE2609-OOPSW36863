/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIceCreamShop.model;

/**
 *
 * @author Isabel Espinosa, EsFuGa
 */
public class IceCream extends Product {

    private int portion;
    private float extrasCost;
    private String flavour;

    public IceCream(int portion, float extrasCost, String flavour,
            int id, String name, float sellingPrice, float cost) {
        super(id, name, sellingPrice, cost);
        this.portion = portion;
        this.extrasCost = extrasCost;
        this.flavour = flavour;
    }

    public IceCream(int portion, float extrasCost, String flavour) {
        super();
        this.portion = portion;
        this.extrasCost = extrasCost;
        this.flavour = flavour;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public float getExtrasCost() {
        return extrasCost;
    }

    public void setExtrasCost(float extrasCost) {
        this.extrasCost = extrasCost;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public double calculatePriceByPortions() {
        return getSellingPrice() * portion;
    }

    public double calculatePriceWithExtras() {
        return calculatePriceByPortions() + extrasCost;
    }
}