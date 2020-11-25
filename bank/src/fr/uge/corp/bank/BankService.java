package fr.uge.corp.bank;

public class BankService {
	
	private final Bank bank = new Bank();
	
	public long getBalance(String account) {
		return bank.getBalance(account);
	}
	
	public long deposit(String account, long amount) {
		return bank.deposit(account, amount);
	}
	
	public long withdraw(String account, long amount) {
		return bank.withdraw(account, amount);
	}
	
	public void transfer(String fromAccount, String toAccount, long amount) {
		bank.transfer(fromAccount, toAccount, amount);
	}
}
