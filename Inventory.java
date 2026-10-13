import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> productMap = new HashMap<>();
    private final List<Product> productList = new ArrayList<>();
    public void addProduct(Product p) {
        
        if(productMap.containsKey(p.getId())) {
            throw new IllegalArgumentException("This Product Already exists in Inventory");
        }
        // productMap.put(p.id, p); // this is invalid is id is provate in product class
        productMap.put(p.getId(),p); // this is valid
        productList.add(p);
    }

    public Product getProduct(String id) {
        return productMap.get(id);
    }

    public void updateStock(String id, int qty) {
        try {
            Product p = productMap.get(id);
            p.setStockQuantity(qty); // called setter of product class
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This product does not exists");
        }
    }

    /** Returns all products in the given category (case-insensitive). Empty list if none. */
    public List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : productList) {
            if (p.getCategory().equalsIgnoreCase(category.trim())) {
                result.add(p);
            }
        }
        return result;
    }

    /** Returns a NEW list sorted by price, cheapest first. The original order is untouched. */
    public List<Product> sortByPrice() {
        List<Product> sorted = new ArrayList<>(productList);
        sorted.sort(Comparator.comparingDouble(Product::getPrice));
        return sorted;
    }

    /** Returns a copy of all products, so callers can't modify the inventory's own list. */
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

}