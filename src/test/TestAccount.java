package test;

import org.junit.*;
import static org.junit.Assert.*;
import bank.*;

public class TestAccount {
	Account checking_account;
	Account savings_account;
	
	@Before
	public void initialize() {
		checking_account = new CheckingAccount(50.0);
		savings_account = new SavingsAccount(50.0);
	}
	
	@Test
	public void test() {
		assertEquals(checking_account.get_account_type(), Account.CHECKING);
		assertEquals(savings_account.get_account_type(), Account.SAVINGS);
		assertEquals(checking_account.get_balance(), 50.0, 0.00000001);
		assertEquals(savings_account.get_balance(), 50.0, 0.00000001);
		savings_account.deposit(50.0);
		assertEquals(savings_account.get_balance(), 100.0, 0.00000001);
		savings_account.end_of_month();
		assertEquals(savings_account.get_balance(), 105.0, 0.00000001);
	}
}