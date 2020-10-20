package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
	
	// Transaction fee 
	private static final double TRANSACTION_FEE = 0.1;

	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
	/**
	 * Compute the management fees to apply in the current account balamce
	 * @param usrID
	 */
	public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            this.setBalance(this.getBalance() - feeAmount);
        	this.resetTransactions();
        }
    }
	
	/**
	 * Withdraw operation
	 * @param usrID
	 * @param amount
	 */
	public void withdraw(final int usrID, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            this.withdraw(usrID, -amount);
        }
    }
	
	/**
	 * Return true if the withdraw is allowed
	 * @param amount
	 * @return
	 */
	private boolean isWithdrawAllowed(final double amount) {
		return this.getBalance() > amount;
	}
}
