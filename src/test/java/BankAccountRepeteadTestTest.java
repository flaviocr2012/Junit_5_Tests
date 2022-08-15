import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeteadTestTest {

    // Useful to execute multiple tests
    @RepeatedTest(5)
    @DisplayName("Deposit 400 sucessfuly")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());

    }

    @RepeatedTest(5)
    @DisplayName("Deposit 400 sucessfuly")
    public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetionInfo ) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
        System.out.println("Nr:" + repetionInfo.getCurrentRepetition());

    }
}
