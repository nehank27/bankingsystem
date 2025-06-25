import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingAccountTest {

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

        double actual = checking.getBalance();
        assertEquals(750, actual);
    }

    @Test
    void withdraw_doesnt_let_go_below0(){
        checking.deposit(1000);
        checking.withdraw(2000);

        double actual = checking.getBalance();
        assertEquals(0, actual);
    }


}
