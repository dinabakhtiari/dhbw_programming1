package blog.loops;

public class treePattern {
    public static void main(String[] args) {
        int height = 5; 

        for (int i = 1; i <= height; i++) {

            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= (2 * i - 1); k++) {
                if (i == 1) System.out.print("+");
                else System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= height - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("****");
        }

    }
}