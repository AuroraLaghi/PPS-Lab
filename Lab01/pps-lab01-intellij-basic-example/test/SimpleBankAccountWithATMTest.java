import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithATM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithATMTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithATM bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithATM(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testDepositWithATM(){
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposiWithATM(){
        bankAccount.depositWithATM(accountHolder.getId(),100);
        bankAccount.depositWithATM(2,50);
        assertEquals(99,bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithATM(){
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        bankAccount.withdrawWithATM(2, 70);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongWidhdrawWithATM(){
        bankAccount.depositWithATM(accountHolder.getId(),100);
        bankAccount.withdrawWithATM(2,70);
        assertEquals(99,bankAccount.getBalance());
    }



}
