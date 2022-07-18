package ru.job4j.cash;

import net.jcip.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Optional;

public class AccountStorage {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    @GuardedBy("accounts")
    public synchronized boolean add(Account account) {
       accounts.put(account.getId(), account);
       return true;
    }

    @GuardedBy("accounts")
    public synchronized boolean update(Account account) {
        accounts.put(account.getId(), new Account(account.getId(), account.getAmount()));
        return true;
    }

    @GuardedBy("accounts")
    public synchronized boolean delete(int id) {
        accounts.remove(id);
        return true;
    }

    @GuardedBy("accounts")
    public synchronized Optional<Account> getById(int id) {
        return Optional.of(accounts.get(id));
    }

    @GuardedBy("accounts")
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        Account fromAccount = accounts.get(fromId);
        fromAccount.setAmount(accounts.get(fromId).getAmount() - amount);
        accounts.put(fromId, fromAccount);
        Account toAccount = accounts.get(toId);
        toAccount.setAmount(accounts.get(toId).getAmount() + amount);
        accounts.put(fromId, toAccount);
        return true;
    }
}
