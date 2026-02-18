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
 static void countdown(int n) {
    if (n > 0) {
      System.out.print(n + " ");
      countdown(n - 1);
    }
  }
  public static void main(String[] args) {
   countdown(5);
  }
}

