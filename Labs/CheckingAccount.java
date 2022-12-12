package CS2336.Labs;
public class CheckingAccount {
	private int accountNumber;
	private double value;
	
	public CheckingAccount(int num, double value2) {
		accountNumber = num;
		value = value2;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public void withdraw(double amount) {
		double temp = value;
	
		if(temp - amount < 0) {System.out.println("Withdraw rejected to avoid negative balance.");}
		else {
			value = temp - amount;
			System.out.println("New balance: " + (value));
		}
	}
	
	public void deposit(double amount) {
		value += amount;
		System.out.println("New balance: " + value);
	}
	
}
