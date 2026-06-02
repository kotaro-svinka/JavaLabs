import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WarehouseTransfer {

    private static class Product {
        private final String name;
        private final int weight;

        public Product(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() { return name; }
        public int getWeight() { return weight; }
    }

    private static void deliverBatch(List<Product> batch, int batchNumber) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        List<Product> warehouse = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            warehouse.add(new Product("Товар-" + i, 50));
        }

        List<CompletableFuture<Void>> deliveryTasks = new ArrayList<>();

        List<Product> currentBatch = new ArrayList<>();
        int currentWeight = 0;
        int batchCounter = 1;

        for (Product product : warehouse) {
            currentBatch.add(product);
            currentWeight += product.getWeight();

            if (currentWeight >= 150) {
                final List<Product> batchToSend = new ArrayList<>(currentBatch);
                final int batchNum = batchCounter;

                CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                    deliverBatch(batchToSend, batchNum);
                });

                deliveryTasks.add(task);

                currentBatch.clear();
                currentWeight = 0;
                batchCounter++;
            }
        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                deliveryTasks.toArray(new CompletableFuture[0])
        );

        try {
            allTasks.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}