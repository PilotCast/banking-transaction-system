package model;

import java.math.BigDecimal;
import java.util.Objects;


public record LedgerEntry(
        String entryId,
        String transactionId,
        String accountId,
        BigDecimal amount,
        LedgerEntryType type
    ) {
    public LedgerEntry {
        Objects.requireNonNull(entryId, "Entry ID required");
        Objects.requireNonNull(transactionId, "Transaction ID required");
        Objects.requireNonNull(accountId, "Account ID required");
        Objects.requireNonNull(amount, "Entry amount required");
        Objects.requireNonNull(type, "Transaction type required");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Entry amount must be greater than zero");
        }
    }

}
