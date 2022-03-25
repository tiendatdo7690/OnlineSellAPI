package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Image;
import com.example.demo.entities.Product;
import com.example.demo.entities.SalesMan;
import com.example.demo.entitiesRequest.CategoryRequest;
import com.example.demo.entitiesRequest.FileRequest;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.entitiesRequest.ProductRespone;
import com.example.demo.respositories.ImagesRespository;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SalesManService salesManService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "saveproduct" ,method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveProduct(@RequestBody ProductRequest productRequest) {


        Category category = categoryService.findById(productRequest.getIdCategory());
        SalesMan salesMan = salesManService.findByUser(productRequest.getIdSalesMan());

        List<Image> images = new ArrayList<Image>();


        String urlAvatar = fileService.upload(productRequest.getAvatar().getName(),
                productRequest.getAvatar().getFile());
        try {

            Product product = productService.saveProduct(productRequest,urlAvatar,category,salesMan);

            for( FileRequest fileRequest : productRequest.getImages()){

                images.add(new Image(fileService.upload(fileRequest.getName(),fileRequest.getFile()),
                        product));
            }
            imageService.saveAll(images);
            return new ResponseEntity<Boolean>(product != null,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findall" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductRespone>> findAll() {

        try {
            List<ProductRespone> productRespones = productService.findAll();
            return new ResponseEntity<List<ProductRespone>>(productRespones,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<ProductRespone>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findallbycategory/{namecategory}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductRespone>> findAllByCategoryName(@PathVariable String namecategory) {

        try {
            List<ProductRespone> productRespones = productService.findAllByCategory(namecategory);
            return new ResponseEntity<List<ProductRespone>>(productRespones,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<ProductRespone>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findallbyname/{key}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductRespone>> findAllByName(@PathVariable String key) {

        try {
            List<ProductRespone> productRespones = productService.findAllByName(key);
            return new ResponseEntity<List<ProductRespone>>(productRespones,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<ProductRespone>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "getproduct/{id}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductRespone> getProduct(@PathVariable Long id) {

        try {
            ProductRespone productRespone = productService.findProductById(id);
            List<Image> images = imageService.findAllByProduct(new Product(productRespone.getId()));
            System.out.println();
            for(Image image: images){
                System.out.println("image name: " + image.getUrl());
                productRespone.getImages().add("http://localhost:8080/uploads/" + image.getUrl());
            }

            return new ResponseEntity<ProductRespone>(productRespone,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<ProductRespone>(HttpStatus.BAD_REQUEST);
        }
    }
}
