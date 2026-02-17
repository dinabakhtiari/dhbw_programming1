package blog.Conditions;

import java.util.Scanner;

public class gradeCalculator_switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your score:");
        int score = input.nextInt();
        switch (score / 10) {
            case 10, 9 :
            System.out.println("Grade A");
            break;
            case 8 :
                System.out.println("Grade B");
                break;
            case 7 :
                System.out.println("Grade C");
                break;
            case 6 :
                 System.out.println("Grade D");
                 break;
            default :
             System.out.println("Grade F");
             break;
        }
    }
    
}
