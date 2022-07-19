package ru.job4j.io;

import java.io.File;
import java.util.function.Predicate;

public interface Content {

    String getContent(Predicate<Character> filter);
}
