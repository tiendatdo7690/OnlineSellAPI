package com.example.demo.services;

import com.example.demo.entitiesRequest.FileRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String upload(String originName, byte[] bytes);
    MultipartFile getFile(String path) throws IOException;
}
