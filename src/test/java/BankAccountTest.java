import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Bank Account class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 500 sucessfuly")
    public void testWithDraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 sucessfuly")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());

    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set Holder Name")
    public void testHolderNameSet() {

        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Flávio");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can withdraw below the minimum")
    public void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withDraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithNoExceptions() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withDraw(400));
    }


}
