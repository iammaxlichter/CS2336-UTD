package CS2336.InClass;

public class Account{

    private static int nextAccountNumber = 1000;
    private int accountNumber; //instance variable - it exists in each object
  
    Account(){
      accountNumber = nextAccountNumber;
      nextAccountNumber++;
    }
  
    public int getAccountNumber(){
      return accountNumber;
    }
  
    public static int getNextAccountNumber(){
      return nextAccountNumber;
    }
  
    public static void setNextAccountNumber(int startingNumber){
      nextAccountNumber = startingNumber;
    }
  
  }
