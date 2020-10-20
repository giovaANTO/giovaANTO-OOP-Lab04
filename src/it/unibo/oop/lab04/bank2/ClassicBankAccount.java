package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {

	 public static final double MANAGEMENT_FEE = 5;
	 public static final double ATM_TRANSACTION_FEE = 1;
	
	public ClassicBankAccount(AccountHolder userAccount, double startingBalance) {
		super(userAccount, startingBalance);
	}	
		
	protected boolean isWithdDrawAllowed(double amount) {
		return true;
	}

	protected double computeFee() {
		return MANAGEMENT_FEE;
	}
}
