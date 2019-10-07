package bank;

import java.util.ArrayList;

/**
 * A class representing a person from the banks perspective
 * @author cameron.davies2
 *
 */

public class Person {
	private ArrayList<Account> accounts;
	private String name;
	
	/**
	 * Basic constructor
	 * @param name	The name of the person
	 */
	public Person(String name) {
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}
	
	/**
	 * Reterns the persons name
	 * @return	name
	 */
	public String get_name() {
		return this.name;
	}
	
	/**
	 * Returns the accounts of the person in an array list
	 * @return	The persons accounts
	 */
	public ArrayList<Account> get_accounts() {
		return accounts;
	}
	
	/**
	 * Creates a new account for the person
	 * @param type	Checking or savings account
	 * @param amount	Initial deposit
	 * @return	The account that was just opened
	 */
	public Account open_account(int type, double amount) {
		Account account = null;
		if(type == Account.SAVINGS) {
			account = new SavingsAccount(amount);
		}
		else if(type == Account.CHECKING) {
			account = new CheckingAccount(amount);
		}
		accounts.add(account);
		return account;
	}
}
