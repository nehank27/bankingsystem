import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {
    Bank bank;

    @BeforeEach
    void setUp(){
        bank = new Bank();
    }

    @Test
    void bank_has_0_accounts_when_created(){
        assertTrue(bank.getAccounts().isEmpty());

    }

    @Test
    void add_account_to_bank(){
        bank.addCorSAccount("12345678", "Saving", 5);
        assertEquals(1, bank.getAccounts().size());
    }
    @Test
    void add_two_accounts_to_bank(){
        bank.addCorSAccount("12345678", "Saving", 5);
        bank.addCDaccount("12091234", 1000, 5);
        assertEquals(2, bank.getAccounts().size());
    }

    @Test
    void deposit_into_bank(){
        bank.addCorSAccount("12345678", "Checking", 10);
        bank.deposit("12345678", 15000);
        double actual = bank.getAccounts().get("12345678").getBalance();
        assertEquals(15000, actual);
    }
    @Test
    void withdraw_from_bank_acc(){
        bank.addCDaccount("12345678", 5000, 10);
        bank.withdraw("12345678", 2500);
        double actual = bank.getAccounts().get("12345678").getBalance();
        assertEquals(2500, actual);
    }
}
