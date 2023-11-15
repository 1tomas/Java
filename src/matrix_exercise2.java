public class matrix_exercise2 {

    final static int N = 5, M = 20, SEP = 0, P = 2, K = 2, L = 'F';

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 2, 'G', 'H', 0, 2, 'G', 3, 0, 3, 'R', 'B', 'J', 0, 6, 5, 'R', 0, 0},
            {0, 1, 2, 'G', 'H', 0, 2, 'A', 3, 0, 3, 'R', 'B', 'J', 0, 6, 5, 'R', 0, 0},
            {0, 1, 2, 'A', 'A', 0, 2, 'A', 3, 0, 3, 'A', 'A', 'A', 0, 6, 5, 'A', 0, 0},
            {0, 1, 2, 'A', 'A', 0, 2, 'A', 3, 0, 3, 'A', 'A', 'A', 0, 6, 5, 'A', 0, 0},
            {0, 1, 2, 'A', 'A', 0, 2, 'A', 3, 0, 3, 'A', 'A', 'A', 0, 6, 5, 'A', 0, 0},
        };

        int signals = 0;

        for (int i = 0; i < N; i++) {
            if (pattern(matrix[i])) {
                signals++;
                if (signals == 2) {
                    System.out.println("Found " + signals + " alien signals");
                }
            } else {
                System.out.println("No signals found");
                signals = 0;
            }
        }
    }

    private static boolean pattern(int[] arr) {
        int start = 0, end = -1;

        boolean meetsCriteria = false;

        while ((start < M)) {
            start = findStart(arr, end + 1);
            if (start < M) {
                end = findEnd(arr, start);
                if (end < M) {
                    if (hasPattern(arr, start, end)) {
                        meetsCriteria = true;
                    }
                }
            }
        }
        return meetsCriteria;
    }

    private static boolean hasPattern(int[] arr, int start, int end) {
        int count = 0;
        while (start <= end && count <= K) {
            if (arr[start] > L) {
                count++;
            }
            start++;
        }
        return (count >= K);
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
