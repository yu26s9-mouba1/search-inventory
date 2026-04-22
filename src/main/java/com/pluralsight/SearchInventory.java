package com.pluralsight;
import java.io.Console;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchInventory {


    private static final String inventoryFilename = "inventory.csv";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ZAM-ZAM Store");

        // Get Inventory
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory:");

        // Display inventory
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);

            // FIXED: printf syntax
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }

        int option;

        do {
            // User options
            String mainMenuPrompt = """
                    
                    what do you want to do?
                    1- List all products
                    2- Lookup a product by its id
                    3- Find all products within a price range
                    4- Add a new product
                    5- Quit the application
                    Enter command:\s""";


//            option = Console.promptForInt(mainMenuPrompt, 1, 5);

            System.out.print(mainMenuPrompt);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    processListAllProducts();
                    break;
                case 2:
                    processSearchByProductId();
                    break;
                case 3:
                    // todo
                    break;
                case 4:
                    // todo
                    break;
            }

        } while (option != 5);
    }

    // Reading File
    public static ArrayList<Product> getInventory() {

        ArrayList<Product> products = new ArrayList<>();

        try {
            FileReader fr = new FileReader(inventoryFilename);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                Product p = getProduct(line);
                products.add(p);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        }

        return products; // FIXED: return correct variable
    }

    private static void processListAllProducts() {
        // todo
    }

    private static void processSearchByProductId() {
        // todo
    }

    //  splitting + data types
    private static Product getProduct(String encodedProductString) {

        String[] tokens = encodedProductString.split("\\|");

        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        double price = Double.parseDouble(tokens[2]);

        return new Product(id, name, price);
    }
}




//package com.pluralsight;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class SearchInventory {
//
//    public static void main(String[] args) {
//        ArrayList<Product> inventory = getInventory();
//
//        for (int i = 0; i < inventory.size(); i++) {
//            Product p = inventory.get(i);
//            System.out.println((i + 1) + ": " + p.getId() + " | " + p.getName() + " | $" + p.getPrice());
//        }
//    }
//
//    public static ArrayList<Product> getInventory() {
//        ArrayList<Product> products = new ArrayList<>();
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
//
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split("\\\\|");
//
//                int id = Integer.parseInt(parts[0]);
//                String name = parts[1];
//                double price = Double.parseDouble(parts[2]);
//
//                Product p = new Product(id, name, price);
//                products.add(p);
//            }
//
//            reader.close();
//
//        } catch (IOException e) {
//            System.out.println("Error reading inventory file.");
//        }
//
//        return products;
//    }
//}
