/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conixcoffeeandicecreamshop;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Beverage;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.IceCream;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;
import java.util.ArrayList;

/**
 *
 * @author Isabel Espinosa, EsFuGa 
 */
public class ConixCoffeeAndIceCreamShop {

    public static void main(String[] args) {
        
       ArrayList<Product> menuList = new ArrayList<>();
       
        menuList.add(new IceCream(1, 0.00f, "Vainilla", 1, "Helado de Vainilla", 2.50f, 1.00f));
        menuList.add(new IceCream(1, 0.00f, "Chocolate", 2, "Helado de Chocolate", 2.50f, 1.10f));
        menuList.add(new IceCream(1, 0.00f, "Menta", 3, "Helado de Menta", 2.70f, 1.15f));
        menuList.add(new IceCream(1, 0.00f, "Maracuyá", 4, "Helado de Maracuyá", 2.70f, 1.20f));
        menuList.add(new IceCream(1, 0.00f, "Mora", 5, "Helado de Mora", 2.50f, 1.05f));
        menuList.add(new IceCream(1, 0.00f, "Frutos Rojos", 6, "Helado de Frutos Rojos", 2.70f, 1.25f));
        
        menuList.add(new Beverage('S', true, 7, "Café Americano", 1.80f, 0.60f));
        menuList.add(new Beverage('M', true, 8, "Café Cappuccino", 2.50f, 0.90f));
        menuList.add(new Beverage('L', false, 9, "Mochaccino Helado", 3.20f, 1.20f));
        menuList.add(new Beverage('M', false, 10, "Milkshake de Chocolate", 3.50f, 1.40f));
        menuList.add(new Beverage('S', true, 11, "Té Caliente de Manzanilla", 1.50f, 0.40f));
        
        menuList.add(new Product(12, "Topping de Chips de Chocolate", 0.50f, 0.15f));
        menuList.add(new Product(13, "Salsa Extra de Chocolate", 0.40f, 0.10f));
        menuList.add(new Product(14, "Cono de Galleta Extra", 0.60f, 0.20f));
      
    }
}
