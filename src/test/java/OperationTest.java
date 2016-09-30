import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    @Test
    public void constructor_shouldInitializeObject() {
        // When
        Operation operation = new Operation(Operation.TransactionType.WITHDRAWAL, 125);

        // Then
        assertEquals(Operation.TransactionType.WITHDRAWAL, operation.getTransactionType());
        assertEquals(125, operation.getAmount());
    }


}