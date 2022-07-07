package ru.job4j;

public final class Cache {
    private static Cache cache = new Cache();

    public static Cache instOf() {
        return cache;
    }
}
