package bank;

/**
 * A template for different kinds of accounts
 * @author cameron.davies2
 *
 */

public interface Account {
	
	/**
	 * Get the current balance of the account
	 * @return	Balance
	 */
	public double get_balance();
	
	/**
	 * Deposits money into the account
	 * @param sum	the amount to deposit
	 */
	public void deposit(double sum);
	
	/**
	 * Withdraw money from the account
	 * @param sum	The money to withdraw
	 * @return	True if money was successfully withdrawn
	 */
	public boolean withdraw(double sum);
	
	/**
	 * Returns remaining number of free transactions this month
	 * @return	Remaining number of free transactions this month
	 */
	public int get_remaining_uses();
	
	/**
	 * Does everything that needs to be done at the end of the month
	 * eg. add interest, reset free transactions
	 */
	public void end_of_month();
	
	/**
	 * Returns if it is a checking or savings account
	 * @return	Account type
	 */
	public AccountType get_account_type();

}
