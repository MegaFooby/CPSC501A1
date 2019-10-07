package bank;

/**
 * A checking account
 * @author cameron.davies2
 *
 */

public class CheckingAccount implements Account {

	private int monthly_uses;
	private int uses_left;
	private double amount;
	private double interest;
	private double penalty;
	
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
	public void deposit(double sum) {
		this.amount = this.amount + sum;
	}
	
	@Override
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

	@Override
	public int get_remaining_uses() {
		return uses_left;
	}

	@Override
	public void end_of_month() {
		this.amount += this.amount * this.interest;
		this.uses_left = this.monthly_uses;
	}

	@Override
	public AccountType get_account_type() {
		return AccountType.CHECKING;
	}

	@Override
	public double get_balance() {
		return amount;
	}
	
}
