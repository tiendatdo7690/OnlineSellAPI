package com.example.demo.controllers;

import com.example.demo.entitiesRequest.CategoryRequest;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "saveproduct" ,method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveProduct(@RequestBody ProductRequest productRequest) {

        try {
            Boolean isSave = productService.saveProduct(productRequest);
            return new ResponseEntity<Boolean>(isSave,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
    }
}
