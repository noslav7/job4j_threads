package ru.job4j.io;

import java.io.*;
import java.util.function.Predicate;

public class Unicode implements Content {
    private File file;

    public Unicode(File file) {
        this.file = file;
    }

    @Override
    public String getContent(Predicate<Character> filter) {
        try (BufferedInputStream i = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            StringBuilder builder = new StringBuilder();
            while ((data = i.read()) != -1) {
                if(filter.test((char) data)) {
                    builder.append((char) data);
                }
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
