package ru.job4j.io;

import java.io.*;

public final class ParseGetFile {
    private final File file;
    private final Content content;

    public ParseGetFile(File file) {
        this.file = file;
        content = new Contents(file);
    }

    public String getContent() throws IOException {
        return content.getContent();
    }

    public String getContentWithoutUnicode() throws IOException {
        return content.getContent();
    }
}
