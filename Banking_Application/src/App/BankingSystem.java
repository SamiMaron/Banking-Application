package App;
import java.util.HashMap;
import java.util.Map;

public class BankingSystem {
	private static BankingSystem instance;
	
	// maybe not needed
	public static synchronized BankingSystem getInstance() {
        if (instance == null) {
            instance = new BankingSystem();
        }
        return instance;
    }
	
	private Map<Integer, Account> accounts;

    private BankingSystem() {
        accounts = new HashMap<>();
    }
    
    public void createAccount (int account_number , double balance , String owner_name) {
		if (!accounts.containsKey(account_number)) {
    		Account account = AccountFactory.createAccount(account_number , balance , owner_name);
        	accounts.put(account_number, account);
			System.out.println("Account created for" +  owner_name + "with account number" + account_number);
    	}
    	else {
    		System.out.println("account already exists");
    	}
    	
    }
    
    class AccountFactory {
        public static Account createAccount(int account_namber , double balance , String owner_name) {
            return new Account(account_namber , balance , owner_name);
        }
    }
    
    public Account getAccount(int account_namber) {
    	return accounts.get(account_namber);
    	
    }
}
