package com.pluralsight;
import java.util.ArrayList;



public class SearchInventory {
    public static void main(String[] args) {

       //Get Inventory
        ArrayList<Product> inventory = getInventory();


        //Display inventory
        for (int i = 0; i < inventory.size(); i++){
            Product p = inventory.get(i);
            System.out.println((i + 1) + " : " + p.getName() + " - $" + p.getPrice());

        }

    }

    public static ArrayList<Product> getInventory(){

        //ArrayList of products
        ArrayList<Product> products = new ArrayList<>();


        //Adding products to the list
        products.add(new Product(1, "Sugar", 3.99));
        products.add(new Product(2, "Biscuit", 5.99));
        products.add(new Product(3, "Water", 2.50));
        products.add(new Product(4, "TV", 89.99));
        products.add(new Product(5, "Computer", 450.99));
        products.add(new Product(6, "Book", 40.99));
        products.add(new Product(7, "T-shirt", 30.99));

        return products;



    }
}
