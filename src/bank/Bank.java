package bank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A bank containing customers and their accounts
 * @author cameron.davies2
 *
 */

public class Bank {
	
	private ArrayList<Person> customers;
	
	/**
	 * Basic constructor
	 */
	public Bank() {
		this.customers = new ArrayList<Person>();
	}
	
	/**
	 * Add a new customer for the bank
	 * @param name	Name of the customer
	 */
	public void add_customer(String name) {
		this.customers.add(new Person(name));
	}
	
	/**
	 * Gets the customer object
	 * @param name	Name of the customer
	 * @return	The person object corresponding to it
	 */
	public Person get_customer(String name) {
		for(Person p : this.customers) {
			if(name.equals(p.get_name())) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Ends the month
	 */
	public void end_month() {
		for(Person p : this.customers) {
			for(Account a : p.get_accounts()) {
				a.end_of_month();
			}
		}
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
				Person person = bank.get_customer(in);
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
						person.open_account(Account.CHECKING, 0);
						break;
					case "2":
					case "savings":
						person.open_account(Account.SAVINGS, 0);
						break;
					default:
						System.out.print("Invalid account type\n");	
					}
				}
				else {
					try {
						int num = Integer.parseInt(in);
						num--;
						if(num > person.get_accounts().size()) {
							throw new NumberFormatException();
						}
						System.out.print("Current balance is $" + person.get_accounts().get(num).get_balance() + ".\n1. Deposit\n2. Withdraw\n");
						in = keyboard.nextLine();
						switch(in.toLowerCase()) {
						case "1":
						case "deposit":
							System.out.print("Select amount\n");
							in = keyboard.nextLine();
							double dep = Double.parseDouble(in);
							person.get_accounts().get(num).deposit(dep);
							break;
						case "2":
						case "withdraw":
							System.out.print("Select amount\n");
							in = keyboard.nextLine();
							double with = Double.parseDouble(in);
							boolean b = person.get_accounts().get(num).withdraw(with);
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
