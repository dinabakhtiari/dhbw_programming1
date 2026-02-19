package blog.Conditions;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int num = input.nextInt();
        int[] fibo = new int[num + 2]; 
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= num; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2]; 
        }
        System.out.println("Result: " + fibo[num]);
    }
}
