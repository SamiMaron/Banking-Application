package App;

public class Account {
	private int account_number;
    private double balance;
    private String owner_mame;
    
    public Account(int account_namber , double balance , String owner_name) {
    	this.account_number = account_namber ;
    	this.balance = balance ;
    	this.owner_mame = owner_name ;
    	
    }
    
    public int getAccountNumber () {
    	return account_number ;
    }
    
    public double getAccountBalance() {
    	return balance ;
    }
    
    public void deposit (double amount) {
    	if(amount >0) {
    		balance += amount ;
    		System.out.println("Deposited: $" + amount);
    	}
    	else {
    		System.out.println("Invalid deposit amount.");
    	}
    }
    
    public boolean withraw (double amount) {
    	if(amount >0) {
    		balance -= amount ;
    		System.out.println("Deposited: $" + amount);
    		return true;
    	}
    	else {
    		System.out.println("Invalid deposit amount.");
    		return false;
    	}
    	
    }
    
    public boolean transferTo(Account targetAccount, double amount) {
        if (withraw(amount)) {
            targetAccount.deposit(amount);
            System.out.println("Transferred: $" + amount + " to account number: " + targetAccount.getAccountNumber());
            return true;
        }
        return false;
    }

}
