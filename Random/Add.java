package CS2336.Random;
import java.util.Scanner;


public class Add {
    
    public static void main(String[] args){
        

        Scanner Input = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int number1 = Input.nextInt();

        System.out.print("Enter number 2: ");
        int number2 = Input.nextInt();

        System.out.print("Total: " + number1 + number2);
        
        Input.close();

    }
}
