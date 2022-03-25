package com.example.demo.controllers;

import com.example.demo.entitiesRequest.FileRequest;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/file")
public class FileRestController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "uploadfiles" ,method = RequestMethod.POST)
    public ResponseEntity<Void> uploadFiles(@RequestBody List<FileRequest> files) {

        try {
            if(files != null) {

                for (FileRequest file : files) {
                    String filename = fileService.upload(file.getName(),file.getFile());
                    System.out.println(filename);
                }
            }
            return new ResponseEntity<Void>(
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "uploadfile" ,method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> uploadFile(@RequestBody FileRequest file) {

        System.out.println("Save File : " + file);
        try {
            if(file != null) {

                System.out.println("Save File khác null: " + file);
                String filename = fileService.upload(file.getName(),file.getFile());
                System.out.println(filename);

            }
            return new ResponseEntity<Void>(
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
