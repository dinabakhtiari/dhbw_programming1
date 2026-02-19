package DataType;

public class TypeCasting {
    public static void main(String[] args) {
        double myDouble = 9.78d;
        int myInt = (int) myDouble;

        System.out.println(myInt);
        System.out.println(myDouble);

        System.out.println("------------------------------");
        int maxScore = 500;
        int userScore = 423;

        double percentage = (double) userScore / maxScore * 100.0d;
        System.out.println("User's percentage is " + percentage);

    }
}
