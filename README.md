# Banking Transaction System

A lightweight terminal-based java application designed to facilitate core banking operations, safely process financial transactions, and track account balances.

## Current Features 
**Account Management** Securely instantiate user accounts with unique indentifiers.
**Core Transactions** Process deposits and withdrawals with real time balance updates.
**Input Validation:** Basic checks to ensure transaction amounts are positive and valid.

## ChangeLog

[2026-07-17] - Initial Project Launch & Git Setup
*   Migrated core backend Java logic (`Main`, `Account`, `User`, `Transaction` `BankService`) to a local, non-syncing workspace on the SSD (`C:\Java-Projects`).
*   Initialized local Git repository and successfully pushed the codebase live to GitHubTr.

[2026-07-18] - Refactored fields from float to BigDecimal across core classes to ensure quantitative integrity.

[2026-07-25] - Refactored the monolithic `Transaction` model into two specialized immutable record models (`Transaction` and `LedgerEntry`), to better ensure data integrity and separation of concerns when generating double entry records. The `ledgerEntry` model generates records concerning a single account, while `Transaction` now handles making the header record containing both accounts in a transfer transaction. 
