package Methods;
import java.util.HashMap;

public class Fibonacci {

    // Using a HashMap for Memoization to store previously calculated values
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    /**
     * 1. Simple Recursive Method
     * Space Complexity: O(n) due to recursion stack
     * Time Complexity: O(2^n) - very slow
     */
    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 2. Iterative Method (Loops)
     * Space Complexity: O(1) - best efficiency as it uses only constant variables
     * Time Complexity: O(n) - very fast
     */
    public static int fibonacciIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * 3. Memoization Method (Recursion + Storage)
     * Space Complexity: O(n) - uses extra memory for the HashMap and stack
     * Time Complexity: O(n) - fast because it avoids redundant calculations
     */
    public static int fibonacciMemo(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        if (memo.containsKey(n)) return memo.get(n);
        
        int result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result); 
        return result;
    }

    public static void main(String[] args) {
        int n = 30; // Test value 
        
        System.out.println("Comparison of Fibonacci Methods for n = " + n);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s\n", "Method", "Time (ns)", "Memory (bytes)");
        System.out.println("------------------------------------------------------------");

        // Measuring Recursive Method
        measurePerformance("Recursive", () -> fibonacci(n));

        // Measuring Iterative Method
        measurePerformance("Iterative", () -> fibonacciIterative(n));

        // Measuring Memoization Method
        measurePerformance("Memoization", () -> fibonacciMemo(n));
    }

    public static void measurePerformance(String name, Runnable method) {
        Runtime runtime = Runtime.getRuntime();
        
        // Suggest Garbage Collection to clear memory before measurement
        runtime.gc(); 
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        long startTime = System.nanoTime();
    }
}