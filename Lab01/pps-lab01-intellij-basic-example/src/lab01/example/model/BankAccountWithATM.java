package lab01.example.model;

public interface BankAccountWithATM extends BankAccount{

    void depositWithATM(int usrID, double amount);

    void withdrawWithATM(int usrID, double amount);
}
