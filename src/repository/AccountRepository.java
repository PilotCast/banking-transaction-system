package repository;

import model.Account;

import java.util.*;
import java.util.Optional;

    public interface AccountRepository {
    Account save(Account account);
    List<Account> findByOwnerId(String ownerId);
    Optional<Account> findByAccountId(String accountId);
    Boolean existsByOwnerId(String ownerId);
    Boolean existsByAccountId(String accountId);
    List<Account> findAll();
    void deleteByAccountId(String accountId);
}
