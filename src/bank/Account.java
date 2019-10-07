package bank;

/**
 * A template for different kinds of accounts
 * @author cameron.davies2
 *
 */

public abstract class Account {
	
	protected int monthly_uses;
	protected int uses_left;
	protected double amount;
	protected double interest;
	protected double penalty;
	
	/**
	 * Get the current balance of the account
	 * @return	Balance
	 */
	public double get_balance() {
		return this.amount;
	}
	
	/**
	 * Deposits money into the account
	 * @param sum	the amount to deposit
	 */
	public void deposit(double sum) {
		this.amount = this.amount + sum;
	}
	
	/**
	 * Withdraw money from the account
	 * @param sum	The money to withdraw
	 * @return	True if money was successfully withdrawn
	 */
	public boolean withdraw(double sum) {
		if(this.uses_left == 0) {
			sum += penalty;
		}
		if(sum > this.amount) {
			return false;
		}
		this.amount -= sum;
		this.uses_left = (this.uses_left-1 > 0) ? this.uses_left-1 : 0;
		return true;
	}
	
	/**
	 * Returns remaining number of free transactions this month
	 * @return	Remaining number of free transactions this month
	 */
	public int get_remaining_uses() {
		return uses_left;
	}
	
	/**
	 * Does everything that needs to be done at the end of the month
	 * eg. add interest, reset free transactions
	 */
	public void end_of_month() {
		this.amount += this.amount * this.interest;
		this.uses_left = this.monthly_uses;
	}
	
	/**
	 * Returns if it is a checking or savings account
	 * @return	Account type
	 */
	public abstract AccountType get_account_type();

}
