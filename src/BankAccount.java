public class BankAccount {
    double apr;
    double balance;

    BankAccount(){
        balance = 0;
    }
    BankAccount(double apr){
        balance = 0;
        this.apr = apr;
    }

    public double getBalance() {
        return balance;
    }

    public double getApr() {
        return apr;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amountToWithdraw) {
        balance -=amountToWithdraw;
        if(balance <=0){
            balance = 0;
        }
    }




}
