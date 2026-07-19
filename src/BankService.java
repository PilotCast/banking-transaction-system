import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class BankService {
    private final Map<String, Account> accountDatabase = new HashMap<>();

    public void saveAccount(Account newAccount) {
        if (newAccount == null) {
            throw new IllegalArgumentException("Cannot save a null account"); }

        this.accountDatabase.put(newAccount.getAccountId(), newAccount);
    }

    public Account findAccountById(String accountId) {
        //If ID isn't there, .get() naturally returns null safely instead of crashing//
        return this.accountDatabase.get(accountId);
    }

    public Transaction executeTransfer(String sourceId, String destinationId, Float amount) {
        Account sender = findAccountById(sourceId);
        Account receiver = findAccountById(destinationId);

        if (sender == null) {
            throw new IllegalArgumentException("Source Account ID is null. ID: " + sourceId);}
        if (receiver == null) {
            throw new IllegalArgumentException("Destination Account ID is null. ID: " + destinationId);}

        sender.debit(BigDecimal.valueOf(amount));
        receiver.credit(BigDecimal.valueOf(amount));

        return new Transaction(sender, receiver, amount);
    }





}