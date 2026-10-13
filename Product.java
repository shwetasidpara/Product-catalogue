public class Product {
    // Private field encapsulation
    private final String id;
    private String name;
    private double price;
    private String category;
    private int stockQuantity;

    Product(String id, String name, double price, String category, int stockQuantity) {
        // Validate everything BEFORE assigning, so an invalid Product can never exist
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be empty");
        }
        this.id = id;
         // reuse setters so validation lives in ONE place
        setName(name);                   
        setPrice(price);
        setCategory(category);
        setStockQuantity(stockQuantity);
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public String getId() {
        return id;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }

     // ---------- Setters (with validation). No setId(): the ID is final. ----------
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category.trim();
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        this.stockQuantity = stockQuantity;
    }
}