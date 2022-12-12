package CS2336.Kattis;

import java.util.Scanner;

public class autori {

    public static void main(String[] args){
        
        Scanner INPUT = new Scanner(System.in);
        String Inp = INPUT.nextLine();

        char letters[] = Inp.toCharArray();
        System.out.print(letters[0]);

        for(int i = 0; i<= letters.length; i++){
            if (letters[i] == '-')
            System.out.print(letters[i+1]);
        
        }
        
        INPUT.close();

    }
 }

