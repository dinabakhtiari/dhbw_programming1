import java.util.Arrays;
import java.util.Date;

public class Variables{

    public static void main(String[] args) {
        //System.out.println("Hi My name is Dina!");
        // int age = 24;
        // System.out.print(age);

        // byte --> 1 byte -128 -- 127
        // short --> 2 byte -32k -- 32k
        // int --> 4 byte -2b -- 2b
        // long --> 8 byte

        // float --> 4 byte
        // double --> 8 byte

        // char
        // boolean 1 byte --> True or False
        // string

        byte age = 24;
        long viewCount = 6123456789L;
        float price = 18.99F;
        boolean darkMode = false;

        Date now = new Date();
        now.getTime();

        System.out.println(now);
        String my_name = "Dina" + " Bakhtiari";
        System.out.println(my_name.startsWith("Di"));
        System.out.println(my_name.length());
        System.out.println(my_name.indexOf("n"));
        System.out.println(my_name.replace("Dina", "Diaro"));
        System.out.println("-----------------------------");

        int[] numbers = new int[4];
        numbers[0] = 2;
        numbers[1] = 4;
        numbers[2] = 6;
        numbers[3] = 8;
        System.out.println(Arrays.toString(numbers));
        System.out.println("-----------------------------");

        int[] numbers_1 = {1, 3, 5, 7};
        System.out.println(numbers_1.length);
        System.out.println("-----------------------------");

        int[][] numbers_2 = new int[2][3];
        numbers_2[0][0] = 1;
        numbers_2[0][1] = 3;
        System.out.println(Arrays.deepToString(numbers_2));
        System.out.println("-----------------------------");

        int[][] numbers_3 = {{ 1, 2, 3}, { 4, 5, 6}, { 7, 8, 9}};
        System.out.println(Arrays.deepToString(numbers_3));
        System.out.println("-----------------------------");
    }
}