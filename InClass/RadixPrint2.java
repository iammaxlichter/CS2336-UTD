package CS2336.InClass;

import java.util.*;

// printRadixRec(n, r): print “” if n is 0
// printRadixRec (n/r, r) followed by n%r otherwise.
// Implement the equivalent non-recursive solution in main() itself.
// DO NOT CREATE any new methods.

class RadixPrint2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        int radix = input.nextInt();
        
        input.close();

        String result = "";

// WRITE YOUR CODE HERE


        if(value == 0){
          result = "0";
        }
        if(value < 0){
          value = Math.abs(value); //Absolute value
          System.out.print("-"); //printing negative right away
        }

        //keep dividing - keep going until value becomes 0
        while(value > 0){
          //              int      + string
          int digitValue = (value % radix);

          if (digitValue < 10)
            result = digitValue + result;
          else
            result = (char) ((digitValue - 10) + (int)'A') + result;


          value /= radix;
          
        }







        System.out.println(result);

    }
}
