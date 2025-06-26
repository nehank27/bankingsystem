public class Checking extends BankAccount{

    Checking(){
        balance = 0;
    }

    Checking(double apr){
        super(apr);
    }
}
