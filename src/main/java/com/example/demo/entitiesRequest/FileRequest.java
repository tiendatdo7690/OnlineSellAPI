package com.example.demo.entitiesRequest;

import java.util.Arrays;

public class FileRequest {

    private byte[] file;
    private String name;

    public FileRequest() {
    }

    public FileRequest(byte[] file, String name) {
        this.file = file;
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FileRequest{" +
                "file=" + Arrays.toString(file) +
                ", name='" + name + '\'' +
                '}';
    }
}
