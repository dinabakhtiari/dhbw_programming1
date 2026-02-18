package Methods;
public class main {
//  public static int sum(int k) {
   // if (k > 0) {
    //  return k + sum(k - 1);
    //} else {
    //  return 0;
   // }
  //}
//public static int sum(int start, int end) {
   // if (end > start) {
   //   return end + sum(start, end - 1);
  //  } else {
   //   return end;
  //  }
 // }
 static int factorial(int n) {
    if (n > 1) {
      return n * factorial(n - 1);
    } else {
      return 1;
    }
  }
 static void countdown(int n) {
    if (n > 0) {
      System.out.print(n + " ");
      countdown(n - 1);
    }
  }
  public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static void main(String[] args) {
   for (int i = 0; i < 10; i++) {
        System.out.println("Fibonacci of " + i + ": " + fibonacci(i));
       // System.out.println("Sum of first 5 natural numbers: " + sum(
      }
   }
}

