package repository;

import model.Account;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, Account> accountStorage = new ConcurrentHashMap<>();


    @Override
    public Account save(Account account) {
        Objects.requireNonNull(account, "Account required");
        accountStorage.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public List<Account> findByOwnerId(String ownerId) {
        if (ownerId == null) {
            return List.of();
        }
        List <Account> matchingAccountList = new ArrayList<>();
        for (Account account : accountStorage.values()) {
            if (account.getOwnerId().equals(ownerId)) {
                matchingAccountList.add(account);
            }
        }
        return matchingAccountList;
    }

    @Override
    public Optional<Account> findByAccountId(String accountId) {
        if (accountId == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(accountStorage.get(accountId));
    }

    @Override
    public Boolean existsByOwnerId(String ownerId) {
        if (ownerId == null) {
            return false;
        }
        for (Account account : accountStorage.values()) {
            if (account.getOwnerId().equals(ownerId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean existsByAccountId(String accountId) {
        if (accountId == null) {
            return false;
        }
        return accountStorage.containsKey(accountId);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accountStorage.values());
    }

    @Override
    public void deleteByAccountId(String accountId) {
        if (accountId == null) {
            return;
        }
        accountStorage.remove(accountId);
    }
}

