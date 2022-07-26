package ru.job4j.cash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.cash.Account;
import ru.job4j.cash.AccountStorage;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountStorageTest {

    @Test
    void whenAdd() {
        AccountStorage storage = new AccountStorage();
        storage.add(new Account(1, 100));
        Account firstAccount = storage.getById(1)
                .orElseThrow(() -> new IllegalStateException("Not found account by id = 1"));
        assertThat(firstAccount.getAmount()).isEqualTo(100);
    }

    @Test
    void whenUpdate() {
        AccountStorage storage = new AccountStorage();
        storage.add(new Account(1, 100));
        storage.update(new Account(1, 200));
        Account firstAccount = storage.getById(1)
                .orElseThrow(() -> new IllegalStateException("Not found account by id = 1"));
        assertThat(firstAccount.getAmount()).isEqualTo(200);
    }

    @Test
    void whenDelete() {
        AccountStorage storage = new AccountStorage();
        storage.add(new Account(1, 100));
        storage.add(new Account(2, 100));
        storage.delete(2);
        boolean outcome = storage.transfer(1, 2, 50);
        assertEquals(false, outcome);
    }

    @Test
    void whenTransfer() {
        AccountStorage storage = new AccountStorage();
        storage.add(new Account(1, 100));
        storage.add(new Account(2, 100));
        storage.transfer(1, 2, 100);
        Account firstAccount = storage.getById(1)
                .orElseThrow(() -> new IllegalStateException("Not found account by id = 1"));
        Account secondAccount = storage.getById(2)
                .orElseThrow(() -> new IllegalStateException("Not found account by id = 1"));
        assertThat(firstAccount.getAmount()).isEqualTo(0);
        assertThat(secondAccount.getAmount()).isEqualTo(200);
    }
}