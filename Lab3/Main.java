public class Main {
    public static void main(String[] args) {
        WarehouseManager warehouse = new WarehouseManager();

        warehouse.addProduct("46012345", new Product("Молоко", 89.90, 50));
        warehouse.addProduct("46054321", new Product("Хлеб", 45.00, 20));

        String searchCode = "46012345";
        Product found = warehouse.findProduct(searchCode);
        if (found != null) {
            System.out.println("Найден: " + found);
        }

        warehouse.removeProduct("46054321");

        warehouse.printAll();
    }
}
