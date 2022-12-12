package CS2336.InClass;

import java.util.Scanner;

class ChangeCombinations {
  static int coinValues[] = {25, 10, 5, 1};

  //counter for all possible combinations to reach the total
  static int numCombinations = 0;

  //count all the coin combinations to reach remainingTotalCents
  //using the coins at coinIndex and beyond... 
  static void change(int coinIndex, int remainingTotalCents) {
      //end conditions?
      if (remainingTotalCents == 0){
        numCombinations++;
        return;
      }
      if(remainingTotalCents < 0 || coinValues.length == coinIndex){
        return;
      }
      //recursive invocations of change()
      change(coinIndex+1, remainingTotalCents); //exclude case
      change(coinIndex, remainingTotalCents-coinValues[coinIndex]);

}

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int totalCents = input.nextInt();
    change(0, totalCents);
    System.out.println(numCombinations);
    input.close();
  }
}