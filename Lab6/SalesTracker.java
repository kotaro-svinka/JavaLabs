import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

public class SalesTracker {
    private Map<Product, Integer> sales = new HashMap<>();

    public void addSale(Product product, int quantity) {
        if (quantity <= 0) return;
        sales.put(product, sales.getOrDefault(product, 0) + quantity);
    }

    public void printSalesList() {
        if (sales.isEmpty()) return;
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            System.out.println(p.getName() + " — Продано: " + qty + " шт.");
        }
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            total += p.getPrice() * qty;
        }
        return total;
    }

    public Product getMostPopularProduct() {
        if (sales.isEmpty()) return null;

        Product mostPopular = null;
        int maxSales = -1;

        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        Product apple = new Product("Яблоко", 50.0);
        Product milk = new Product("Молоко", 90.0);
        Product bread = new Product("Хлеб", 40.0);

        tracker.addSale(apple, 5);
        tracker.addSale(milk, 2);
        tracker.addSale(apple, 10);
        tracker.addSale(bread, 4);

        tracker.printSalesList();

        System.out.println("\nОбщая сумма продаж: " + tracker.calculateTotalRevenue() + " руб.");

        Product popular = tracker.getMostPopularProduct();
        if (popular != null) {
            System.out.println("Наиболее популярный товар: " + popular.getName());
        }
    }
}
