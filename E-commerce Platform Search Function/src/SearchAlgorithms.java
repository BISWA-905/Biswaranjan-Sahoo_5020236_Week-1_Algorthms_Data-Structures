
import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {
    // Linear search implementation
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary search implementation
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(productName);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Create a sample array of products
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Tablet", "Electronics"),
            new Product("4", "Headphones", "Accessories"),
            new Product("5", "Charger", "Accessories")
        };

        // Sort the products array for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        // Perform linear search
        String searchProductName = "Tablet";
        Product result = linearSearch(products, searchProductName);
        System.out.println("Linear Search Result: " + result);

        // Perform binary search
        result = binarySearch(products, searchProductName);
        System.out.println("Binary Search Result: " + result);
    }
}