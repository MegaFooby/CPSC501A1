package bank;

import java.util.*;

/**
 * A bank containing customers and their accounts
 * @author cameron.davies2
 *
 */

public class Bank {
	
	private HashMap<String, ArrayList<Account>> customers;
	
	/**
	 * Basic constructor
	 */
	public Bank() {
		this.customers = new HashMap<String, ArrayList<Account>>();
	}
	
	/**
	 * Add a new customer for the bank
	 * @param name	Name of the customer
	 */
	public void add_customer(String name) {
		this.customers.put(name, new ArrayList<Account>());
	}
	
	/**
	 * Gets the customer object
	 * @param name	Name of the customer
	 * @return	The person object corresponding to it
	 */
	public ArrayList<Account> get_customer(String name) {
		return customers.get(name);
	}
	
	/**
	 * Ends the month
	 */
	public void end_month() {
		for(ArrayList<Account> p : this.customers.values()) {
			for(Account a : p) {
				a.end_of_month();
			}
		}
	}
	
	public Account open_account(String name, AccountType type, double amount) {
		Account account = null;
		if(type == AccountType.SAVINGS) {
			account = new SavingsAccount(amount);
		}
		else if(type == AccountType.CHECKING) {
			account = new CheckingAccount(amount);
		}
		this.get_customer(name).add(account);
		return account;
	}
	
	/**
	 * Test with basic command line input
	 * @param args
	 */
	public static void main(String args[]) {
		Bank bank = new Bank();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Welcome to the bank\n");
		while(true) {
			System.out.print("Please enter the name of the customer or type \"new\" to create a new customer or \"exit\" to exit\n");
			String in = keyboard.nextLine();
			if(in.equalsIgnoreCase("exit")) {
				break;
			} else if(in.equalsIgnoreCase("new")) {
				System.out.print("Please enter the name of the new customer\n");
				in = keyboard.nextLine();
				bank.add_customer(in);
			} else {
				String name = in;
				ArrayList<Account> person = bank.get_customer(in);
				if(person == null) {
					System.out.print("Customer not found\n");
					continue;
				}
				System.out.print("Select an account number or type \"new\" to make a new account\n");
				in = keyboard.nextLine();
				if(in.equalsIgnoreCase("new")) {
					System.out.print("Please select an account type:\n1. Checking\n2. Savings\n");
					in = keyboard.nextLine();
					switch(in.toLowerCase()) {
					case "1":
					case "checking":
						bank.open_account(name, AccountType.CHECKING, 0.0);
						break;
					case "2":
					case "savings":
						bank.open_account(name, AccountType.SAVINGS, 0.0);
						break;
					default:
						System.out.print("Invalid account type\n");	
					}
				}
				else {
					try {
						int num = Integer.parseInt(in);
						num--;
						if(num > person.size()) {
							throw new NumberFormatException();
						}
						System.out.print("Current balance is $" + person.get(num).get_balance() + ".\n1. Deposit\n2. Withdraw\n");
						in = keyboard.nextLine();
						switch(in.toLowerCase()) {
						case "1":
						case "deposit":
							System.out.print("Select amount\n");
							in = keyboard.nextLine();
							double dep = Double.parseDouble(in);
							person.get(num).deposit(dep);
							break;
						case "2":
						case "withdraw":
							System.out.print("Select amount\n");
							in = keyboard.nextLine();
							double with = Double.parseDouble(in);
							boolean b = person.get(num).withdraw(with);
							if(b == false) {
								System.out.print("Failed to withdraw\n");
							}
							break;
						}
					} catch(NumberFormatException e) {
						System.out.print("Invalid option\n");
					}
				}
			}
		}
		keyboard.close();
	}
}
