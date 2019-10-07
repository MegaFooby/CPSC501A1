package bank;

/**
 * A checking account
 * @author cameron.davies2
 *
 */

public class CheckingAccount extends Account {
	
	/**
	 * Basic constructor
	 * @param amount	Initial deposit
	 */
	public CheckingAccount(double amount) {
		this.monthly_uses = 30;
		this.uses_left = this.monthly_uses;
		this.amount = amount;
		this.interest = 0.0001;
		this.penalty = 3.95;
	}

	@Override
	public AccountType get_account_type() {
		return AccountType.CHECKING;
	}
	
}
