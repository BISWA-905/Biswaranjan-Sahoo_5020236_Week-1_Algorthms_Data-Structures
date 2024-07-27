
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    // Constructor
    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update a product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Display all products
    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        // Add products
        ims.addProduct(new Product("1", "Laptop", 10, 999.99));
        ims.addProduct(new Product("2", "Smartphone", 20, 499.99));
        
        // Update a product
        ims.updateProduct(new Product("1", "Laptop", 15, 949.99));
        
        // Display products
        ims.displayProducts();
        
        // Delete a product
        ims.deleteProduct("2");
        
        // Display products
        ims.displayProducts();
    }
}
