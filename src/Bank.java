import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts;

    Bank(){
        accounts = new HashMap<>();
    }


    public Map<String, BankAccount> getAccounts() {
        return accounts;
    }

    public void addCorSAccount(String accID, String accType, double apr) {
        if(accType == "Checking"){
            accounts.put(accID, new Checking(apr));
        } else{
            accounts.put(accID, new Savings(apr));
        }
    }

    public void addCDaccount(String accID, double balance, double apr){
        accounts.put(accID, new CertificateOfDeposit(balance, apr));
    }

    public void deposit(String accID, double depositAmount) {
        accounts.get(accID).deposit(depositAmount);
    }

    public void withdraw(String accID, double withdrawAmount) {
        accounts.get(accID).withdraw(withdrawAmount);
    }
}
