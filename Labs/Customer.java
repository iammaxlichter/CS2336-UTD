package CS2336.Labs;

import java.util.*;

public class Customer {
	private String name;
	private int numOfCheckingAccount;
	private int accountNumber;
	
	public CheckingAccount[] checking; // {null, null, null, null, null}
	 
	//						filled			filled/not imp		filled			not filled
	public Customer(String customerName, int numOfAcc, int accountNum, int checkingAccountNumber){
		this.name = customerName;
		this.numOfCheckingAccount = numOfAcc;
		this.accountNumber = accountNum;
		
		checking = new CheckingAccount [5];
		
		System.out.println("Customer ID: " + getAccountNumber());
		
		
		addChecking(numOfCheckingAccount, checkingAccountNumber);
		
	}
	
	public String getName() {return name;}
	public int getAccountNumber() {return  accountNumber;}
	public int getNumOfCheckingAccount() {return numOfCheckingAccount;}
	
	public void addAccount(int num, double amount, int checkingAccountNumber) {
		if(num + numOfCheckingAccount > 5) {
			System.out.println("Error: Customer already has 5 accounts.");
		} else {
			int temp = numOfCheckingAccount;
			for(int i = temp; i < num + temp; i++) {
				checking[i] = new CheckingAccount(checkingAccountNumber++, amount);
				numOfCheckingAccount++;
			}
			for(int i = temp; i < num + temp; i++) {
				System.out.println("Account ID: " + checking[i].getAccountNumber());
			}
		}
	}
	
	public void addChecking(int numOfAccounts, int checkingAccountNumber) {
		if(numOfAccounts > 5) { 
			System.out.println("Error: Customer already has 5 accounts.");
		} else {
			Scanner input = new Scanner(System.in);
			String valueString = input.nextLine(); //getting the number string of accounts
			String[] string = valueString.split(" "); //making that string into an array
			double[] arr = new double[numOfAccounts]; //making that string array into a double array
			for(int i = 0; i<string.length; i++){
				arr[i] = Double.valueOf(string[i]); //copying the values of the string array into the double array
			}

			for(int i = 0; i < numOfAccounts; i++) {
				double value = arr[i];
				checking[i] = new CheckingAccount(checkingAccountNumber++, value);
			}
			
			for(int i = 0; i < numOfAccounts; i++) {
				System.out.println("Account ID: " + checking[i].getAccountNumber());
			}

			numOfAccounts += numOfAccounts;
			input.close();
		}
	}
	
}