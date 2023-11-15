public class matrix_exercise1 {
    public final static int SEP = 0;
    public final static int M = 20;
    public final static int N = 3;

    public static void main(String[] args) {

        int[][] matrix = {{0, -8, 67, 0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 25, 25, 0, -5, 3, 0, 25, 44, 44, 0, -4, 1, 0, 0, 0, 0, 0, 0},
                          {0, 44, 44, 44, 0, -7, 15, 0, -4, 9, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0}};

        for (int i = 0; i < N; i++)
            decompress(matrix[i]);
        display(matrix);
    }

    private static void decompress(int[] arr) {
        int start = 0, end = -1;
        while ((start < M)) {
            start = findStart(arr, end + 1);
            if (start < M) {
                end = findEnd(arr, start);
                if (arr[start] < 0) {
                    decompressSequence(arr, start);
                }
            }
        }
    }

    private static void decompressSequence(int[] arr, int start) {
        int aux = arr[start] * -1;
        arr[start] = arr[start + 1];
        for (int pos = 0; pos < aux - 2; pos++) {
            shiftRight(arr, start);
        }
    }

    private static void shiftRight(int[] arr, int start) {
        for (int i = M - 1; i > start; i--) {
            arr[i] = arr[i - 1];
        }
    }

    private static int findStart(int[] arr, int start) {
        while (start < M && arr[start] == SEP) {
            start++;
        }
        return start;
    }

    private static int findEnd(int[] arr, int start) {
        while (start < M && arr[start] != SEP) {
            start++;
        }
        return start - 1;
    }

    public static void display(int[][] matrix) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(matrix[i][j] + "|");
            System.out.println();
        }
    }
}
