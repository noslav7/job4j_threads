package ru.job4j.cash;

import net.jcip.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Optional;

public class AccountStorage {
    @GuardedBy("accounts")
    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public synchronized boolean add(Account account) {
        return accounts.putIfAbsent(account.getId(), account) == null;
    }

    public synchronized boolean update(Account account) {
        return accounts.replace(account.getId(), account) != null;
    }

    public synchronized boolean delete(int id) {
        return accounts.remove(id) != null;
    }

    public synchronized Optional<Account> getById(int id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        Optional<Account> fromAccount = getById(fromId);
        Optional<Account> toAccount = getById(toId);
        if (fromAccount.isPresent() && toAccount.isPresent() && amount >= fromAccount.get().getAmount()) {
            fromAccount.get().setAmount(fromAccount.get().getAmount() - amount);
            toAccount.get().setAmount(toAccount.get().getAmount() + amount);
            result = true;
        }
        return result;
    }
}
