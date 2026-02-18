package Methods;
import java.util.HashMap;

public class Fibonacci {

    private static HashMap<Integer, Integer> memo = new HashMap<>();
    

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

   
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

    
    public static int fibonacciMemo(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 30; 
        long start, end;

        System.out.println("Comparing Fibonacci methods for n = " + n + "\n");

        start = System.nanoTime();
        int res1 = fibonacci(n);
        end = System.nanoTime();
        System.out.println("1. Recursive Time: " + (end - start) + " ns | Result: " + res1);

        start = System.nanoTime();
        int res2 = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("2. Iterative Time: " + (end - start) + " ns | Result: " + res2);

        start = System.nanoTime();
        int res3 = fibonacciMemo(n);
        end = System.nanoTime();
        System.out.println("3. Memoized Time:  " + (end - start) + " ns | Result: " + res3);
    }
}