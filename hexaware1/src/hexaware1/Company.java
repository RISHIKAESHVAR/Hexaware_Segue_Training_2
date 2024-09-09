package hexaware1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {

    public static void main(String[] args) {
        List<Product> pl = new ArrayList<>();
        initializeProductList(pl);
        Scanner scanner = new Scanner(System.in);

        displayProducts(pl);

        System.out.println("Enter the product name to search:");
        String searchProductName = scanner.nextLine();

        Product foundProduct = searchProduct(pl, searchProductName);

        if (foundProduct != null) {
            processPurchase(scanner, foundProduct);
        } else {
            System.out.println("Product not found");
        }

        scanner.close();
    }

    private static void initializeProductList(List<Product> pl) {
        pl.add(new Product("java", 2000.0, 100));
        pl.add(new Product("dsa", 3000.0, 144));
        pl.add(new Product("c++", 4000.0, 466));
        pl.add(new Product("dbms", 5000.0, 441));
        pl.add(new Product("os", 6000.0, 456));
    }

    private static void displayProducts(List<Product> pl) {
        System.out.println("Available products:");
        for (Product product : pl) {
            System.out.println(product);
        }
    }

    private static Product searchProduct(List<Product> pl, String productName) {
        for (Product product : pl) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private static void processPurchase(Scanner scanner, Product product) {
        System.out.println("Product found");
        System.out.println(product);

        System.out.println("Enter quantity:");
        int requestedQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (requestedQuantity <= product.getStockQty()) {
            double totalCost = product.getUp() * requestedQuantity;
            System.out.println("Total Cost: " + totalCost + " Rs");
        } else {
            System.out.println("We have " + product.getStockQty() + " units of " + product.getProductName() + ". Do you want to purchase all?");
            System.out.println("Enter yes or no:");
            String userResponse = scanner.nextLine();

            if (userResponse.equalsIgnoreCase("yes")) {
                double totalCost = product.getUp() * product.getStockQty();
                System.out.println("Total Cost: " + totalCost + " Rs");
            } else {
                System.out.println("Purchase cancelled");
            }
        }
    }
}

