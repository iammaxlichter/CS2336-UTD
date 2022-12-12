package CS2336.Labs;

import java.util.LinkedList;
import java.util.*;

public class BankOperations {
    public static void main(String[] args) {
        int customerNumStart = 1000001;
        int checkingNumStart = 5000001;
        int numOfCustomers = 0;
        int numberCheckingAccounts = 0;
        LinkedList<Customer> list = new LinkedList<Customer>();
        Scanner input = new Scanner(System.in);

        boolean isTrue = true;

        while(isTrue) {
            String userInput = input.next();
            switch(userInput) {
            case "new":
                int num = input.nextInt();
                String name = input.nextLine();
                name = name.substring(1);
                if(num > 5) {
                    System.out.println("MAX 5 accounts per customer!");
                } else {
                    list.add(new Customer(name, num, customerNumStart, checkingNumStart ));
                    customerNumStart++;
                    numOfCustomers++;
                    numberCheckingAccounts += num;
                    checkingNumStart += num;
                }
                break;

            case "deposit":
                int accountDepositNumber = input.nextInt();
                double depositAmount = input.nextDouble();
                for(int i = 0; i < numOfCustomers; i++) {
                    Customer curr = list.get(i);
                    for(int k = 0; k < curr.getNumOfCheckingAccount(); k++) {
                        if(curr.checking[k].getAccountNumber() == accountDepositNumber) {
                            curr.checking[k].deposit(depositAmount);
                        }
                    }
                }
                break;
            case "withdraw":
                int accountWithdrawNumber = input.nextInt();
                double withdrawAmount = input.nextDouble();
                for(int i = 0; i < numOfCustomers; i++) {
                    Customer curr = list.get(i);
                    for(int k = 0; k < curr.getNumOfCheckingAccount(); k++) {
                        if(curr.checking[k].getAccountNumber() == accountWithdrawNumber) {
                            curr.checking[k].withdraw(withdrawAmount);
                        }
                    }
                }
                break;
            case "add":
                int numToAdd = input.nextInt();
                String n = input.nextLine().substring(1);
                if(numToAdd+numberCheckingAccounts>5){
                    System.out.println("Error: Customer already has 5 accounts.");
                    break;
                }
                double amount = input.nextDouble();
                boolean isNumber = true;
                for(int i = 0; i < n.length(); i++) {
                    if(Character.isDigit(n.charAt(i)) == false) {
                        isNumber = false;
                        break;
                    }
                }
                if(isNumber) {
                    int accountNum = Integer.parseInt(n);
                    for(int i = 0; i < numOfCustomers; i++) {
                        Customer curr = list.get(i);
                        if(curr.getAccountNumber() == accountNum) {
                            numberCheckingAccounts += numToAdd;
                            curr.addAccount(numToAdd, amount , checkingNumStart);
                            
                        }
                    }
                } else {
                    for(int i = 0; i < numOfCustomers; i++) {
                        Customer curr = list.get(i);
                        if(curr.getName().equals(n)) {
                            numberCheckingAccounts += numToAdd;
                            curr.addAccount(numToAdd, amount , checkingNumStart );
                        }
                    }
                    checkingNumStart += numToAdd;
                }
                break;
                
            case "close":
                isTrue = false;
                break;	

            default:
                break;
        }

        input.close();
    }
}
    

    
    
    
}