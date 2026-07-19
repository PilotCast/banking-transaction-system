import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private final String sourceAccountId;
    private final String destinationAccountId;
    private final BigDecimal amount;
    private final LocalDateTime timeStamp;

    public Transaction(Account sender, Account receiver, Float transferAmount) {
        //Extracting Values
        this.sourceAccountId = sender.getAccountId();
        this.destinationAccountId = receiver.getAccountId();
        this.amount = BigDecimal.valueOf(transferAmount);

        //Validation of values amount
        if (transferAmount <= 0) {
            throw new IllegalArgumentException("Transaction Amount must be greater than zero.");}

        //Stop account from self transferring
        // we use equal() because the ids are strings
        if (this.sourceAccountId.equals(destinationAccountId)) {
            throw new IllegalArgumentException("The Source and Destination accounts cannot be the same");}

        //AUTO GENERATE
        this.transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8);
        this.timeStamp = LocalDateTime.now();
    }

    //Getters
    public String getTransactionId() {return this.transactionId;}
    public String getSourceAccountId() {return this.sourceAccountId;}
    public String getDestinationAccountId() {return this.destinationAccountId;}
    public BigDecimal getAmount() {return this.amount;}
    public LocalDateTime getTimeStamp() {return this.timeStamp;}

    @Override
    public String toString() {
        return String.format(
                "\n=========================================\n" +
                        "             OFFICIAL RECEIPT            \n" +
                        "=========================================\n" +
                        "Transaction ID : %s\n" +
                        "Timestamp      : %s\n" +
                        "Sender ID      : %s\n" +
                        "Receiver ID    : %s\n" +
                        "Amount Moved   : $%.2f\n" +
                        "=========================================",
                this.transactionId,
                this.timeStamp,
                this.sourceAccountId,
                this.destinationAccountId,
                this.amount
        );
    }
}
