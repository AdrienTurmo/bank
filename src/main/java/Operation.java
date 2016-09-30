public class Operation {

    public enum TransactionType {
        WITHDRAWAL,
        DEPOSIT
    }

    private TransactionType transactionType;
    private int amount;

    public Operation(TransactionType transactionType, int amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    public int getAmount() {
        return this.amount;
    }
}
