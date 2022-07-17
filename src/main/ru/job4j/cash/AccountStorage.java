package ru.job4j.cash;

import java.util.HashMap;
import java.util.Optional;

public class AccountStorage {
    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public synchronized boolean add(Account account) {
        return false;
    }

    public synchronized boolean update(Account account) {
        return false;
    }

    public synchronized boolean delete(int id) {
        return false;
    }

    public synchronized Optional<Account> getById(int id) {
        return Optional.empty();
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        return false;
    }
}
