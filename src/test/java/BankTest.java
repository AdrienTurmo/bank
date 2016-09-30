import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BankTest {

    /*
    On va programmer un banque avec ces fonctionnalités :
    - déposer de l'argent
    - retirer de l'argent
    - afficher le montant
    */

    @Test
    public void displayBalance_ShouldReturnZero() {
        // Given
        Bank bank = new Bank();

        // When
        int balance = bank.getBalance();

        // Then
        assertEquals(0, balance);
    }

    @Test
    public void displayBalance_ShouldReturnInitialValue() {
        // Given
        Bank bank = new Bank(10);

        // When
        int balance = bank.getBalance();

        // Then
        assertEquals(10, balance);
    }

    @Test
    public void addDeposit_shouldIncreaseMyMoney() {
        // Given
        Bank bank = new Bank();

        // When
        bank.addDeposit(100);

        // Then
        assertEquals(100, bank.getBalance());
    }

    @Test
    public void addDeposit_shouldIncreaseMyMoney_fromInitialValue() {
        // Given
        Bank bank = new Bank(100);

        // When
        bank.addDeposit(110);

        // Then
        assertEquals(210, bank.getBalance());
    }

    @Test
    public void withdraw_shouldDecreaseMyMoney() throws NoMoneyException {
        // Given
        Bank bank = new Bank(100);

        // When
        bank.withdraw(10);

        // Then
        assertEquals(90, bank.getBalance());
    }

    @Test(expected = NoMoneyException.class)
    public void withdraw_shouldRaiseNoMoneyException_whenNotEnoughtMoney() throws NoMoneyException {
        // Given
        Bank bank = new Bank(100);

        // When
        bank.withdraw(110);
    }

    @Test
    public void getHistory_ShouldReturnEmptyAccountHistory_WhenNoRecordedOperation() {
        // Given
        Bank bank = new Bank();

        // When
        ArrayList<Operation> history = bank.getHistory();

        // Then
        assertEquals(0, history.size());
    }

    @Test
    public void addDeposit_ShouldAddNewOperationInHistory() {
        // Given
        Bank bank = new Bank();

        // When
        bank.addDeposit(100);
        ArrayList<Operation> history = bank.getHistory();

        // Then
        assertEquals(1, history.size());
        Operation firstOperation = history.get(0);
        assertEquals(Operation.TransactionType.DEPOSIT, firstOperation.getTransactionType());
        assertEquals(100, firstOperation.getAmount());

    }

    @Test
    public void withdraw_ShouldAddNewOperationInHistory() throws NoMoneyException {
        // Given
        Bank bank = new Bank(1000);

        // When
        bank.withdraw(110);
        ArrayList<Operation> history = bank.getHistory();

        // Then
        assertEquals(1, history.size());
        assertEquals(Operation.TransactionType.WITHDRAWAL, history.get(0).getTransactionType());
        assertEquals(110, history.get(0).getAmount());

    }

    @Test
    public void getTotalDeposit_ShouldReturnTotalDeposit() throws NoMoneyException {
        // Given
        Bank bank = new Bank();
        bank.addDeposit(50);
        bank.withdraw(10);
        bank.addDeposit(60);
        // When

        // Then
        assertEquals(110,bank.getTotalDeposit());
    }

    @Test
    public void getTotalDeposit_ShouldReturnTotalDeposit2() throws NoMoneyException {
        // Given
        Bank bank = new Bank();
        bank.addDeposit(50);
        bank.addDeposit(50);
        bank.withdraw(10);
        bank.addDeposit(60);
        // When

        // Then
        assertEquals(160,bank.getTotalDeposit());
    }

}
