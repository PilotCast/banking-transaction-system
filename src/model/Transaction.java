package model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

public record Transaction(
        String transactionId,
        String sourceAccountId,
        String targetAccountId,
        BigDecimal amount,
        TransactionType type,       //DEPOSIT, WITHDRAWAL, TRANSFER
        Instant timestamp,
        List<LedgerEntry> entries )
    {
        //Rule checks
        public Transaction {
            //Non-null checks:
            Objects.requireNonNull(transactionId, "model.Transaction ID required");
            Objects.requireNonNull(amount, "Transfer amount required");
            Objects.requireNonNull(type, "model.Transaction type required");
            Objects.requireNonNull(entries, "Ledger entries list required");
            //Ensure amount is more than zero
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Transfer amount must be greater than zero");
            }
            //Make sure transactions have both source and target accounts
            if (type == TransactionType.TRANSFER) {
                if (sourceAccountId == null || targetAccountId == null) {
                    throw new IllegalArgumentException("Transfers require both source and target accounts");
                }
            }
            //Ensure both accounts aren't the same
            if (type == TransactionType.TRANSFER && sourceAccountId.equalsIgnoreCase(targetAccountId)) {
                throw new IllegalArgumentException("source and target accounts cannot be the same.");
            }

            // Make sure both leg ledger entries get entered
            if (type == TransactionType.TRANSFER && entries.size() < 2) {
                throw new IllegalArgumentException("A transfer Must contain at least two ledger legs");
            }

        }


    public static Transaction createTransferTx(

            String sourceAccountId,
            String targetAccountId,
            BigDecimal amount
        ) {
            //Master header ID
            String headerId = "Trx_" + UUID.randomUUID().toString();
            Instant now = Instant.now();

            //Source model.Account Leg
            LedgerEntry sourceLeg = new LedgerEntry(
                    "Leg_" + UUID.randomUUID().toString(),
                    headerId,
                    sourceAccountId,
                    amount,
                    LedgerEntryType.DEBIT
            );

            //Target model.Account Leg
            LedgerEntry targetLeg = new LedgerEntry(
                    "Leg_" + UUID.randomUUID().toString(),
                    headerId,
                    targetAccountId,
                    amount,
                    LedgerEntryType.CREDIT
            );

            return new Transaction(
                    headerId,
                    sourceAccountId,
                    targetAccountId,
                    amount,
                    TransactionType.TRANSFER,
                    now,
                    List.of(sourceLeg, targetLeg)
            );



    }


 }