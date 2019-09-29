package ru.cloudStorage.example.common;



public class FileRequest extends AbstractMessage {
    private String filename;
    private String operationType;

    public String getFilename() {
        return filename;
    }

    public String getOperationType() {
        return operationType;
    }

    public FileRequest(String filename, String operationType) {
        this.filename = filename;
        this.operationType = operationType;
    }
}
