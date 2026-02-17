package blog.Conditions;

import java.util.Scanner;

public class rockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter rock, paper, or scissors: ");
        String player = input.next();
        String computer = "rock";

        if (player.equals(computer)) {
            System.out.println("Tie!");
        } else {
            switch (player) {
                case "rock":
                    if (computer.equals("scissors")) System.out.println("You win!");
                    else System.out.println("Computer wins!");
                    break;
                case "paper":
                    if (computer.equals("rock")) System.out.println("You win!");
                    else System.out.println("Computer wins!");
                    break;
                case "scissors":
                    if (computer.equals("paper")) System.out.println("You win!");
                    else System.out.println("Computer wins!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        
        }
    }
    
}
