import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Accounts {

    Checking checking;

    @BeforeEach
    void setUp(){
        checking = new Checking();
    }

    @Test
    void initial_balance_is_zero(){
        double actual = checking.getBalance();
        assertEquals(0, actual);
    }

    @Test
    void apr_value_is_same_as_supplied(){
        Checking checking = new Checking(5.5);
        double actual = checking.getApr();
        assertEquals(5.5, actual);
    }

    @Test
    void balance_increases_by_deposit_amount(){
        checking.deposit(500);
        checking.deposit(3000);
        double actual = checking.getBalance();
        assertEquals(3500, actual);
    }

    @Test
    void withdraw_decreases_by_amount(){
        checking.deposit(1000);
        checking.withdraw(250);
        checking.withdraw(500);

        double actual = checking.getBalance();
        assertEquals(250, actual);
    }

    @Test
    void withdraw_doesnt_let_go_below0(){
        checking.deposit(100);
        checking.withdraw(200);

        double actual = checking.getBalance();
        assertEquals(0, actual);
    }

    @Test
    void savings_withdraw_doesnt_let_go_below0(){
        Savings savings = new Savings();
        savings.deposit(100);
        savings.withdraw(200);

        double actual = savings.getBalance();
        assertEquals(0, actual);
    }

    @Test
    void cd_account_starts_with_speciifed_balance(){
        CertificateOfDeposit cd = new CertificateOfDeposit(1000, 5);
        double actual = cd.getBalance();

        assertEquals(1000, actual);
    }



}
