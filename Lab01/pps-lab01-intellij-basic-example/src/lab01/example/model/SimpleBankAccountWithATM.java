package lab01.example.model;

public class SimpleBankAccountWithATM extends SimpleBankAccount implements BankAccountWithATM {

    public SimpleBankAccountWithATM(AccountHolder holder,double balance) {
        super(holder,balance);
    }

    public void withdrawWithATM(final int userId, final double amount){
        withdraw(userId,amount + 1);
    }

    public void depositWithATM(final int userId, final double amount){
        deposit(userId,amount - 1);
    }

}
