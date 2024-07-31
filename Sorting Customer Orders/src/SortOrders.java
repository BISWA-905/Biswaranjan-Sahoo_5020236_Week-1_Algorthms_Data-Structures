
public class SortOrders {
	// Bubble Sort implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) break;
        }
    }

    // Quick Sort implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);  // Recursively sort elements before partition
            quickSort(orders, pi + 1, high); // Recursively sort elements after partition
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Create a sample array of orders
        Order[] orders = {
            new Order("1", "Alice", 300.00),
            new Order("2", "Bob", 150.50),
            new Order("3", "Charlie", 200.00),
            new Order("4", "David", 500.00),
            new Order("5", "Eve", 450.75)
        };

        // Perform Bubble Sort
        bubbleSort(orders);
        System.out.println("Bubble Sorted Orders by Total Price:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Re-initialize the array for Quick Sort
        orders = new Order[]{
            new Order("1", "Alice", 300.00),
            new Order("2", "Bob", 150.50),
            new Order("3", "Charlie", 200.00),
            new Order("4", "David", 500.00),
            new Order("5", "Eve", 450.75)
        };

        // Perform Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("Quick Sorted Orders by Total Price:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
