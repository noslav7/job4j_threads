package ru.job4j.io;

import java.io.*;

public final class ParseSaveFile {
    private final File file;

    public ParseSaveFile(File file) {
        this.file = file;
    }

    public void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        }
    }
}
