package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import bank.*;

public class TestBank {
	
	private Bank bank;
	
	@Before
	public void initialize() {
		bank = new Bank();
		bank.add_customer("Bob");
		ArrayList<Account> bob = bank.get_customer("Bob");
		bank.open_account("Bob", AccountType.CHECKING, 50.0);
	}
	
	@Test
	public void test_customers() {
		assertNotNull(bank.get_customer("Bob"));
		assertEquals(bank.get_customer("Bob").get(0).get_balance(), 50.0, 0.00000001);
	}
	
}
