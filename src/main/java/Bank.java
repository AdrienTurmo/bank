import java.util.ArrayList;

public class Bank {

    private int balance = 0;
    private ArrayList<Operation> operations = new ArrayList<Operation>();

    public Bank(int initialBalance) {
        this.balance = initialBalance;
    }

    public Bank() {
    }

    public int getBalance() {
        return this.balance;
    }

    public void addDeposit(int amount) {
        this.balance += amount;
        Operation operation = new Operation(Operation.TransactionType.DEPOSIT, amount);
        this.operations.add(operation);
    }

    public void withdraw(int amount) throws NoMoneyException {
        if (amount > this.balance) {
            throw new NoMoneyException();
        }
        this.balance -= amount;
        Operation operation = new Operation(Operation.TransactionType.WITHDRAWAL, amount);
        this.operations.add(operation);
    }

    public ArrayList<Operation> getHistory() {
        return this.operations;
    }

    public int getTotalDeposit() {
        return this.operations.stream()
                .filter(operation -> {
                    return operation.getTransactionType() == Operation.TransactionType.DEPOSIT;
                })
                .mapToInt(operation -> operation.getAmount()).sum();
    }
}
