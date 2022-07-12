package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;

public final class ParseFile {
    private File file;
    private Content contentType;

    public ParseFile(File f) {
        this.file = f;
    }

    public void saveContent(String content) throws IOException {
        try (BufferedOutputStream outStream = new BufferedOutputStream(Files.newOutputStream(file.toPath()))) {
            for (int i = 0; i < content.length(); i += 1) {
                outStream.write(content.charAt(i));
            }
        }
    }
}
