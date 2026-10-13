import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
        private static final Scanner scanner = new Scanner(System.in);
        private static final Inventory inventory = new Inventory();
        private static final List<Product> productList = new ArrayList<>();
        private List<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        printMenu();

        boolean running = true;
        while(running) {
            System.out.print("Choose an option: ");
            String inputStr = scanner.nextLine().trim();
            int choice = Integer.parseInt(inputStr);
            try {
                switch(choice) {
                    case 1:
                        // fetch product id
                        System.out.print("Enter Product Id: ");
                        String idStr = scanner.nextLine().trim();

                        // fetch name
                        System.out.print("Enter Product Name: ");
                        String nameStr = scanner.nextLine().trim();

                        // fetch price
                        System.out.print("Enter Product Price: ");
                        String priceInput = scanner.nextLine().trim();
                        double priceP = Double.parseDouble(priceInput);

                        // fetch product category
                        System.out.print("Enter Product category");
                        String categoryStr = scanner.nextLine().trim();

                        // fetch stock quanityt
                        System.out.print("Enter Stock Quanityt In Inventory: ");
                        String stockInput = scanner.nextLine().trim();
                        int stock = Integer.parseInt(stockInput);

                        inventory.addProduct(new Product(idStr, nameStr, priceP, categoryStr, stock));
                        System.out.println("Product has been added.");
                        break;
                    case 2:
                        // fetch product id
                        System.out.print("Enter Product Id: ");
                        String idP = scanner.nextLine().trim();
                        // fetch stock quanityt
                        System.out.print("Enter Stock Quanityt In Inventory: ");
                        String stockInputS = scanner.nextLine().trim();
                        int stockP = Integer.parseInt(stockInputS);

                        inventory.updateStock(idP, stockP);
                        System.out.println("After updateStock(25): " + inventory.getProduct(idP));
                        break;
                    case 3:
                        // search by category
                        System.out.print("Enter product category: ");
                        String category = scanner.nextLine().trim();
                        printProducts(inventory.searchByCategory(category));
                        break;
                        
                    case 4:
                        printProducts(inventory.sortByPrice());
                        break;
                    case 5:
                        printProducts(inventory.getAllProducts());
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 0-5.");
                }
            } catch(IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

     // ---------- Display ----------
private static void printProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.printf("%-8s %-15s %10s  %-12s %6s%n", "ID", "Name", "Price", "Category", "Stock");
        for (Product p : products) {
            System.out.printf("%-8s %-15s %10.2f  %-12s %6d%n",
                    p.getId(), p.getName(), p.getPrice(), p.getCategory(), p.getStockQuantity());
        }
    }
    private static void printMenu() {
        System.out.println();
        System.out.println("===== Inventory Menu =====");
        System.out.println("1. Add product");
        System.out.println("2. Update stock");
        System.out.println("3. Search by category");
        System.out.println("4. Sort by price");
        System.out.println("5. Show all");
        System.out.println("0. Exit");
    }
}