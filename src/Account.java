import java.util.UUID;
import java.math.BigDecimal;


public class Account {
    //UserId to mirror ownerId
    String ownerId;
    BigDecimal balance;
  //final//
    final String accountId;

    public Account(User owner) {
        this.ownerId = owner.getUserId();

        this.accountId = "ACC" + UUID.randomUUID().toString().substring(0, 8);

        this.balance = new BigDecimal("0.00");

    }

    //Debit / Withdrawing money
    public void debit(BigDecimal debitAmount) {
        if (debitAmount  == null || debitAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException ("Debit amount must be positive");
        }
        if (this.balance.compareTo(debitAmount) < 0) {
            throw new IllegalArgumentException("Insufficient funds for transaction");
        }
        this.balance = this.balance.subtract(debitAmount);
    }

    //Credit / Depositing Money
    public void credit(BigDecimal creditAmount) {
        if (creditAmount == null || creditAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException ("Debit amount must be positive");
        }
        this.balance = this.balance.add(creditAmount);
    }

    //Getters
    String getAccountId() {
        return this.accountId; }
    BigDecimal getAccountBalance() {
        return this.balance;
    }


}
