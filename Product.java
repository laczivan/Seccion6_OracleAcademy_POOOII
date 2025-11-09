/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.iz.producttester;

/**
 *
 * @author zunig
 */
ic class Product {
    private String name;
    private int quantity;
    private double price;
    private int elementNumber;

    public Product(String name, int quantity, double price, int elementNumber) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.elementNumber = elementNumber;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + ", elementNumber=" + elementNumber + '}';
    } 
    
    }


