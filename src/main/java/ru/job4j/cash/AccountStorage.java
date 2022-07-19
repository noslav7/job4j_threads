package ru.job4j.cash;

import net.jcip.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Optional;

public class AccountStorage {
    @GuardedBy("accounts")
    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public synchronized boolean add(Account account) {
       accounts.putIfAbsent(account.getId(), account);
       return true;
    }

    public synchronized boolean update(Account account) {
        accounts.replace(account.getId(), account);
        return true;
    }

    public synchronized boolean delete(int id) {
        return accounts.remove(id) == null;
    }

    public synchronized Optional<Account> getById(int id) {
        return Optional.of(accounts.get(id));
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        Optional<Account> fromAccount = getById(fromId);
        int newFromAmount = 0;
        if (fromAccount.isPresent()) {
            newFromAmount = fromAccount.get().getAmount() - amount;
        }
        if (newFromAmount <= 0) {
            return false;
        }
        fromAccount.get().setAmount(newFromAmount);
        accounts.replace(fromId, fromAccount.get());
        Optional<Account> toAccount = getById(toId);
        int newToAmount = 0;
        if (toAccount.isPresent()) {
            newToAmount = toAccount.get().getAmount() + amount;
            toAccount.get().setAmount(newToAmount);
        }
        return true;
    }
}
