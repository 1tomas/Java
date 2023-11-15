public class matrix_exercise3 {
        final static int M = 15, N = 7, SEP = 0;
        final static int X = 600;
    
        public static void main(String[] args) {
            int[][] trainingMatrix = {
                {0, 0, 150, 200, 165, 0, 154, 352, 240, 256, 0, 900, 750, 0, 0}, // 0
                {0, 940, 105, 265, 845, 215, 0, 245, 765, 348, 0, 745, 125, 541, 0}, // 1
                {0, 851, 543, 625, 845, 914, 0, 754, 10000, 452, 1600, 0, 0, 0, 0}  // 2
            };
    
            int[] A1 = {1, 2, 0};
            int[] A2 = {3, 0, 0};
    
            averageSales(A1, A2, trainingMatrix);
        }
    
        private static void averageSales(int[] a1, int[] a2, int[][] mat) {
            int i = 0, averageGreaterAmount = 0, averageDailySales = 0;
    
            while (i < N && a1[i] != SEP) {
                averageGreaterAmount = calculateAverageGreaterAmount(mat[a1[i] - 1]);
                System.out.println("The average of greater amount for month " + a1[i] + " is: " + averageGreaterAmount);
                i++;
            }
    
            i = 0;
    
            while (i < N && a2[i] != SEP) {
                averageDailySales = calculateDailyAverage(mat[a2[i] - 1]);
    
                if (averageDailySales > X) {
                    System.out.println("The daily average for month " + a2[i] + " was greater than " + X);
                } else {
                    System.out.println("The daily average for month " + a2[i] + " was not greater than " + X);
                }
                i++;
            }
        }
    
        private static int calculateDailyAverage(int[] month) {
            int start = 0, end = -1, total = 0, size = 0;
    
            while (start < M) {
                start = findStart(month, end + 1);
                if (start < M) {
                    end = findEnd(month, start);
                    if (end < M) {
                        size = end - start + 1;
                        total = calculateTotal(month, start, end);
                    }
                }
            }
            return total / size;
        }
    
        private static int calculateTotal(int[] month, int start, int end) {
            int total = 0;
            while (start < end) {
                total += month[start];
                start++;
            }
            return total;
        }
    
        private static int calculateAverageGreaterAmount(int[] month) {
            int start = 0, end = -1, greaterAmounts = 0, count = 0;
            while (start < M) {
                start = findStart(month, end + 1);
                if (start < M) {
                    end = findEnd(month, start);
                    if (end < M) {
                        greaterAmounts += greaterAmount(month, start, end);
                        count++;
                    }
                }
            }
            return greaterAmounts / count;
        }
    
        private static int greaterAmount(int[] month, int start, int end) {
            int greater = 0;
            while (start < end) {
                if (month[start] > greater) {
                    greater = month[start];
                }
                start++;
            }
            return greater;
        }
    
        private static int findStart(int[] arr, int start) {
            while (start < M && arr[start] == 0) {
                start++;
            }
            return start;
        }
    
        private static int findEnd(int[] arr, int start) {
            while (start < M && arr[start] != 0) {
                start++;
            }
            return start - 1;
        }
    }