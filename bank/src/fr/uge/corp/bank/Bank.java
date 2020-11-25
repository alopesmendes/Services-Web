package fr.uge.corp.bank;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
	
	private final ConcurrentHashMap<String, Long> balanceByAccount = new ConcurrentHashMap<>();

	public long getBalance(String account) {
		Objects.requireNonNull(account);
		Long balance = balanceByAccount.get(account);
		if (balance == null) {
			throw new IllegalArgumentException("Account " + account + " does not exist");
		}
		return balance;
	}

	public long deposit(String account, long amount) {
		Objects.requireNonNull(account);
		if (amount <= 0) {
			throw new IllegalArgumentException("amount <= 0");
		}
		return balanceByAccount.merge(account, amount, Long::sum);
	}

	public long withdraw(String account, long amount) {
		Objects.requireNonNull(account);
		if (amount <= 0) {
			throw new IllegalArgumentException("amount <= 0");
		}
		return balanceByAccount.compute(account, (k, v) -> {
			if (v == null) {
				throw new IllegalArgumentException("Account " + account + " does not exist");
			}
			if (v < amount) {
				throw new IllegalArgumentException("Not enough money on account " + account + ": attempted to withdraw "
						+ amount + ", balance is " + v);
			}
			return v - amount;
		});
	}

	public void transfer(String fromAccount, String toAccount, long amount) {
		Objects.requireNonNull(fromAccount);
		Objects.requireNonNull(toAccount);
		if (amount <= 0) {
			throw new IllegalArgumentException("amount <= 0");
		}
		if (!balanceByAccount.containsKey(fromAccount)) {
			throw new IllegalArgumentException("fromAccount " + fromAccount + " does not exist");
		}
		if (!balanceByAccount.containsKey(toAccount)) {
			throw new IllegalArgumentException("toAccount " + toAccount + " does not exist");
		}
		balanceByAccount.replaceAll((k, v) -> {
			if (k.equals(fromAccount)) {
				if (v < amount) {
					throw new IllegalArgumentException("Not enough money on account " + fromAccount
							+ ": attempted to transfer " + amount + ", balance is " + v);
				}
				return v - amount;
			}
			if (k.equals(toAccount)) {
				return v + amount;
			}
			return v;
		});
	}
}
