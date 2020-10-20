package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.AccountHolder;
import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {

	public static final double MANAGEMENT_FEE = -5;
	public static final double ATM_TRANSACTION_FEE = 1;

	private final AccountHolder account;
	private double balance;
	private int nTransactions;

	public AbstractBankAccount(final AccountHolder userAccount, double startingBalance, int startingTransactions) {
		this.account = userAccount;
		this.balance = startingBalance;
		this.nTransactions = startingTransactions;
	}

	public AbstractBankAccount(final AccountHolder userAccount, double startingBalance) {
		this(userAccount, startingBalance, 0);
	}

	public void computeManagementFees(int usrID) {
		if (this.checkAccount(usrID)) {
			this.modifyBalance(-this.computeFee());
		}
	}

	public void deposit(int usrID, double amount) {
		this.transactionOp(usrID, amount);
	}

	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount + ATM_TRANSACTION_FEE);
	}

	public double getBalance() {
		return this.balance;
	}

	public int getNTransactions() {
		return this.nTransactions;
	}

	public void withdraw(int usrID, double amount) {
		if (this.isWithdDrawAllowed(amount)) {
			this.transactionOp(usrID, -amount);
		}
	}

	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount + ATM_TRANSACTION_FEE);
	}

	protected void resetTransactions() {
		this.nTransactions = 0;
	}

	protected abstract boolean isWithdDrawAllowed(double amount);

	protected abstract double computeFee();

	private void incrementTransCount() {
		this.nTransactions = this.nTransactions + 1;
	}

	private boolean checkAccount(int usrID) {
		return this.account.getUserID() == usrID;
	}

	private void setBalanace(double amount) {
		this.balance = amount;
	}

	private void modifyBalance(double amount) {
		this.setBalanace(this.balance + amount);
	}

	private void transactionOp(int usrID, double amount) {
		if (this.checkAccount(usrID)) {
			this.modifyBalance(amount);
			this.incrementTransCount();
		}
	}
}
