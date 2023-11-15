public class matrix_exercise5 {

        public final static int SEP = 0;
        public final static int N = 7;
        public final static int M = 20;
        public final static float P = 0.5f;
    
        public static void main(String[] args) {
    
            int[][] trainingMatrix = {
                    {0, 300, 298, 788, 297, 0, 240, 233, 273, 230, 0, 257, 254, 254, 0, 234, 230, 222, 0, 0},
                    {0, 310, 302, 284, 271, 0, 280, 263, 293, 0, 0, 0, 264, 264, 0, 234, 230, 0, 0, 0},
                    {0, 310, 302, 294, 0, 0, 250, 243, 0, 245, 0, 257, 255, 253, 0, 234, 229, 0, 0, 0},
                    {0, 315, 320, 395, 398, 0, 351, 333, 353, 0, 0, 0, 334, 354, 0, 454, 490, 499, 0, 0},
                    {0, 410, 400, 397, 0, 0, 250, 243, 0, 0, 0, 257, 255, 253, 0, 234, 229, 220, 0, 0},
                    {0, 0, 420, 430, 430, 450, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 415, 425, 435, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            int[] trainingArray = {1, 2, 5, 0, 0, 0, 0};
    
            processTraining(trainingMatrix, trainingArray);
            displayArray(trainingArray);
    
        }
    
        private static void processTraining(int[][] mat, int[] arr) {
            int i = 0, trainedDays = 0, fulfilledDays = 0;
            while (i < N && arr[i] != SEP) {
                if (progressiveTraining(mat[arr[i] - 1])) {
                    fulfilledDays++;
                    shiftLeft(arr, i);
                } else
                    i++;
                trainedDays++;
    
            }
            float total = (float) fulfilledDays / (float) trainedDays;
    
            if (total > P) {
                System.out.println("Fulfilled");
            } else {
                System.out.println("Not fulfilled");
            }
    
        }
    
        private static void shiftLeft(int[] arr, int pos) {
            for (int i = pos; i < N - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
    
        private static boolean progressiveTraining(int[] arr) {
            int start = 0, end = -1;
            boolean progressive = true;
    
            while (start < M && progressive) {
                start = findStart(arr, end + 1);
                if (start < M) {
                    end = findEnd(arr, start);
                    progressive = isProgressive(arr, start, end);
                }
    
            }
            return progressive;
        }
    
        private static boolean isProgressive(int[] arr, int start, int end) {
            while (start < end && arr[start] >= arr[start + 1]) {
                start++;
            }
            return start == end;
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
    
        public static void displayArray(int[] arr) {
            for (int i = 0; i < N; i++)
                System.out.print(arr[i] + "|");
            System.out.println("");
        }
    
    }
    

