public class ArraySum {

    private static class SumWorker extends Thread {
        private final int[] array;
        private final int start;
        private final int end;
        private long partialSum;

        public SumWorker(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }

        public long getPartialSum() {
            return partialSum;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int midpoint = numbers.length / 2;

        SumWorker worker1 = new SumWorker(numbers, 0, midpoint);
        SumWorker worker2 = new SumWorker(numbers, midpoint, numbers.length);

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        long totalSum = worker1.getPartialSum() + worker2.getPartialSum();

        System.out.println("Сумма первой половины: " + worker1.getPartialSum());
        System.out.println("Сумма второй половины: " + worker2.getPartialSum());
        System.out.println("Общая сумма элементов массива: " + totalSum);
    }
}