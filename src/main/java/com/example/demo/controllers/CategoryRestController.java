package com.example.demo.controllers;

import com.example.demo.entitiesRequest.CategoryRequest;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "savecategory" ,method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveCategory(@RequestBody CategoryRequest categoryRequest) {

        try {
            Boolean isSave = categoryService.saveCategory(categoryRequest);
            return new ResponseEntity<Boolean>(isSave,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findall" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryRequest>> findAll() {

        try {
            List<CategoryRequest> categoryRequests = categoryService.findAll();
            return new ResponseEntity<List<CategoryRequest>>(categoryRequests,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<CategoryRequest>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findallbyname/{name}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryRequest>> findAllByName(@PathVariable String name) {

        try {
            List<CategoryRequest> categoryRequests = categoryService.findAllCategoryByName(name);
            return new ResponseEntity<List<CategoryRequest>>(categoryRequests,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<CategoryRequest>>(HttpStatus.BAD_REQUEST);
        }
    }
}
