public class Checking {
    private double apr;
    private double balance = 0;
    Checking(){
        balance = 0;

    }
    Checking(double apr){
        this.apr = apr;

    }



    public double getBalance() {
        return balance;
    }

    public double getApr() {
        return apr;
    }

    public void deposit(int amount) {
        balance += amount;


    }

    public void withdraw(int amountToWithdraw) {
        balance -=amountToWithdraw;
        if(balance <=0){
            balance = 0;
        }
    }
}
