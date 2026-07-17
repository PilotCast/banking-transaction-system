import java.util.UUID;

public class Account {
    //UserId to mirror ownerId
    String ownerId;
    Float balance;
  //final//
    final String accountId;

    public Account(User owner) {
        this.ownerId = owner.getUserId();

        this.accountId = "ACC" + UUID.randomUUID().toString().substring(0, 8);

        this.balance = (float)0;

    }

    //Debit / Withdrawing money
    public void debit(Float debitAmount) {
        if (debitAmount <= 0) {
            throw new IllegalArgumentException ("Debit amount must be positive");
        }
        if (this.balance < debitAmount) {
            throw new IllegalArgumentException("Insufficient funds for transaction");
        }
        this.balance -= debitAmount;
    }

    //Credit / Depositing Money
    public void credit(Float creditAmount) {
        if (creditAmount <= 0) {
            throw new IllegalArgumentException ("Debit amount must be positive");
        }
        this.balance += creditAmount;
    }

    //Getters
    String getAccountId() {
        return this.accountId; }
    Float getAccountBalance() {
        return this.balance;
    }


}
