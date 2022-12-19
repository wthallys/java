import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid position!");
        }
        catch (InputMismatchException exception) {
            System.out.println("Input error!");
        }

        System.out.println("End of program!");


    }
}