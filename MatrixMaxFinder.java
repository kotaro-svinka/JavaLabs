public class MatrixMaxFinder {

    private static class RowMaxWorker extends Thread {
        private final int[] row;
        private int maxInRow;

        public RowMaxWorker(int[] row) {
            this.row = row;
            this.maxInRow = Integer.MIN_VALUE;
        }

        @Override
        public void run() {
            for (int num : row) {
                if (num > maxInRow) {
                    maxInRow = num;
                }
            }
        }

        public int getMaxInRow() {
            return maxInRow;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 18, 5, 12},
                {45, 2, 89, 21},
                {14, 7, 33, 60}
        };

        int rowCount = matrix.length;

        RowMaxWorker[] workers = new RowMaxWorker[rowCount];

        for (int i = 0; i < rowCount; i++) {
            workers[i] = new RowMaxWorker(matrix[i]);
        }

        for (int i = 0; i < rowCount; i++) {
            workers[i].start();
        }

        try {
            for (int i = 0; i < rowCount; i++) {
                workers[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        int absoluteMax = Integer.MIN_VALUE;

        for (int i = 0; i < rowCount; i++) {
            int localMax = workers[i].getMaxInRow();
            if (localMax > absoluteMax) {
                absoluteMax = localMax;
            }
        }
        System.out.println("\nНаибольший элемент во всей матрице: " + absoluteMax);
    }
}