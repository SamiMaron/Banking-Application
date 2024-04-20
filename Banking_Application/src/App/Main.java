package App;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BankingSystem bankingSystem = BankingSystem.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
            System.out.println("\nWelcome To Banking Application");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch(choice) {
              case 1:
                  System.out.print("Enter account number: ");
                  int accountNumber = scanner.nextInt();
                  System.out.print("Enter owner name: ");
                  String ownerName = scanner.next();
                  System.out.print("Enter initial balance: ");
                  double initialBalance = scanner.nextDouble();
                  bankingSystem.createAccount(accountNumber, initialBalance, ownerName);
                  break;
              case 2:
                  System.out.print("Enter account number: ");
                  accountNumber = scanner.nextInt();
                  Account account = bankingSystem.getAccount(accountNumber);
                  if (account != null) {
                      System.out.print("Enter deposit amount: ");
                      double depositAmount = scanner.nextDouble();
                      account.deposit(depositAmount);
                  } else {
                      System.out.println("Account not found.");
                  }
                  break;
              case 3:
            	  System.out.print("Enter account number: ");
                  accountNumber = scanner.nextInt();
                  Account account1 = bankingSystem.getAccount(accountNumber);
                  if (account1 != null) {
                      System.out.print("Enter deposit amount: ");
                      double withrawAmount = scanner.nextDouble();
                      account1.withraw(withrawAmount);
                  } else {
                      System.out.println("Account not found.");
                  }
                  break;
              case 4:
            	  System.out.print("Enter source account number: ");
                  int sourceAccountNumber = scanner.nextInt();
                  Account sourceAccount = bankingSystem.getAccount(sourceAccountNumber);
                  if (sourceAccount != null) {
                	  System.out.print("Enter target account number: ");
                      int targetAccountNumber = scanner.nextInt();
                      Account targetAccount = bankingSystem.getAccount(targetAccountNumber);
                      if(targetAccount != null) {
                    	  System.out.print("Enter transfer amount: ");
                          double transferAmount = scanner.nextDouble();
                          sourceAccount.transferTo(targetAccount, transferAmount);
                      }
                      else {
                          System.out.println("Target account not found.");
                      }
                   }
                   else {
                	   System.out.println("Source account not found."); 
                      }
            	  break;
              case 5:
            	  System.out.print("Enter account number: ");
                  accountNumber = scanner.nextInt();
                  account = bankingSystem.getAccount(accountNumber);
                  if (account != null) {
                      System.out.println("Account balance: $" + account.getAccountBalance());
                  } else {
                      System.out.println("Account not found.");
                  }
            	  break;
              case 6:
            	  System.out.println("Exiting the application.");
                  scanner.close();
                  return;
              default:
                  System.out.println("Invalid choice. Please try again.");
            	  
            	  
            	
            
            }
		}

	}

}
