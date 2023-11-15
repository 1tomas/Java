
    public class matrix_exercise4 {
        public final static int N = 4;
        public final static int M = 16;
        public final static char SEP = ' ';
    
        public static void main(String[] args) {
            char[][] document = {{' ', 'e', 'l', ' ', 'a', 'g', 'e', 'n', 't', 'e', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', 'J', 'a', 'm', 'e', 's', ' ', 'B', 'o', ' ', 's', 'e', ' ', ' ', ' ', ' '},
                    {' ', 'e', 'n', 'c', 'u', 'e', 'n', 't', 'r', 'a', ' ', 'e', 'n', ' ', ' ', ' '},
                    {' ', 'C', 'o', 'l', 'o', 'n', 'i', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    
            System.out.println("Encrypted " + traverseDocument(document) + " sequences.");
    
            display(document);
        }
    
        private static int traverseDocument(char[][] document) {
            int encryptedSequences = 0;
            for (int i = 0; i < N; i++) {
                encryptedSequences += encryptDocument(document[i]);
            }
            return encryptedSequences;
        }
    
        private static int encryptDocument(char[] arr) {
            int start = 0, end = -1, encryptedSequences = 0;
            while ((start < M)) {
                start = findStart(arr, end + 1);
                if (start < M) {
                    end = findEnd(arr, start);
                    if (isName(arr, start)) {
                        encryptSequence(arr, start, end);
                        encryptedSequences++;
                    }
                }
            }
            return encryptedSequences;
        }
    
        public static int encryptSequence(char[] arr, int start, int end) {
            reverse(arr, start, end);
            return duplicateVowel(arr, start, end);
        }
    
        private static int duplicateVowel(char[] arr, int start, int end) {
    
            int encryptedSequences = 0;
            while (start <= end) {
                if (isVowel(arr[start])) {
                    shiftRight(arr, start);
                    start++;
                    end++;
                    encryptedSequences++;
                }
                start++;
            }
            return encryptedSequences;
        }
    
        private static void shiftRight(char[] arr, int start) {
            for (int i = M - 1; i > start; i--) {
                arr[i] = arr[i - 1];
            }
        }
    
        public static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    
        private static boolean isName(char[] arr, int start) {
            return arr[start] >= 'A' && 'Z' >= arr[start];
        }
    
        private static void reverse(char[] arr, int start, int end) {
            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    
        private static int findStart(char[] arr, int start) {
            while (start < M && arr[start] == SEP) {
                start++;
            }
            return start;
        }
    
        private static int findEnd(char[] arr, int start) {
            while (start < M && arr[start] != SEP) {
                start++;
            }
            return start - 1;
        }
    
        public static void display(char[][] matrix) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    System.out.print(matrix[i][j] + "|");
                System.out.println();
            }
        }
    }
    

