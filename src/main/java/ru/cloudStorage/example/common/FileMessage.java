package ru.cloudStorage.example.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMessage extends AbstractMessage {
    private String filename;
    private byte[] data;
    private String operationType;

    public String getFilename() {
        return filename;
    }

    public byte[] getData() {
        return data;
    }

    public String getOperationType() {
        return operationType;
    }

    public FileMessage(Path path, String operationType) throws IOException {
        this.operationType = operationType;
        filename = path.getFileName().toString();
        data = Files.readAllBytes(path);
    }
}
