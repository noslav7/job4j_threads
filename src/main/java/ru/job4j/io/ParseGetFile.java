package ru.job4j.io;

import java.io.File;
import java.io.IOException;

public final class ParseGetFile {
    private final File file;
    private final Content content;

    public ParseGetFile(File file) {
        this.file = file;
        content = new Contents(file);
    }

    public synchronized String getContent() throws IOException {
        return content.getContent(x -> true);
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        return content.getContent(x -> x < 0x80);
    }
}
