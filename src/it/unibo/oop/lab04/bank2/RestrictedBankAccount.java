package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {

	private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;
	
	public RestrictedBankAccount(AccountHolder userAccount, double startingBalance) {
		super(userAccount, startingBalance);
	}	
	
    public void computeManagementFees(final int usrID) {
    	if (this.isWithdDrawAllowed(this.computeFee())) {
    		super.computeManagementFees(usrID);
    		super.resetTransactions();
    	}
    }
	
	protected boolean isWithdDrawAllowed(double amount) {
		return this.getBalance() > amount;
	}

	protected double computeFee() {
		return MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
	}

}
