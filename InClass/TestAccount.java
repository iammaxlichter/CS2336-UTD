package CS2336.InClass;

import java.util.Scanner;

public class TestAccount{

  public static void main(String args[]){

    Scanner input = new Scanner(System.in);

    int startNumber = input.nextInt();
    int numAccounts = input.nextInt();
    Account.setNextAccountNumber(startNumber);

    for(int i = 0; i<numAccounts; i++){
      Account acc = new Account();
      System.out.println(acc.getAccountNumber());
    }
    
    input.close();

    System.out.println("Next Account Number: " + Account.getNextAccountNumber());
  }
}
