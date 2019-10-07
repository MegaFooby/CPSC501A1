package bank;

/**
 * A savings account
 * @author cameron.davies2
 *
 */

public class SavingsAccount extends Account {

	/**
	 * Basic constructor
	 * @param amount	Initial deposit
	 */
	public SavingsAccount(double amount) {
		this.monthly_uses = 2;
		this.uses_left = this.monthly_uses;
		this.amount = amount;
		this.interest = 0.05;
		this.penalty = 10.95;
	}
	
	@Override
	public AccountType get_account_type() {
		return AccountType.SAVINGS;
	}

}
