package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.entitiesRequest.FileRequest;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.entitiesRequest.ProductRespone;
import com.example.demo.respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private FileService fileService;
    @Autowired
    private ProductRespository productRespository;

    @Override
    public Product saveProduct(ProductRequest productRequest, String urlAvatar, Category category, SalesMan salesMan) {

        Product product = new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getInventoryNumber(),
                productRequest.getDateSell(),productRequest.getStatus(),salesMan,
                category);
        product.setUrlAvatar(urlAvatar);

        return productRespository.save(product);
    }

    @Override
    public List<ProductRespone> findAll() throws IOException {

        return setPriceAndUrlImage(productRespository.findAllBy());
    }

    private List<ProductRespone> setPriceAndUrlImage(List<ProductRespone> productRespones) {
        for(ProductRespone productRespone : productRespones){
            List<Price> prices = productRespository.getPriceOfProduct(productRespone.getId());
            Double price = 0.0;

            if(prices.size() > 0) {
                price = prices.get(0).getPrice();
            }
            productRespone.setPrice(price);
            System.out.println("Product id: " + productRespone.getId() + " Giá : " + price);
            productRespone.setUrlFileAvatar("http://localhost:8080/uploads/" + productRespone.getUrlFileAvatar());
        }
        return productRespones;
    }

    @Override
    public ProductRespone findProductById(Long id) {
        List<Price> prices = productRespository.getPriceOfProduct(id);
        Double price = 0.0;

        if(prices.size() > 0) {
            price = prices.get(0).getPrice();
            System.out.println("Product id: " + id + " Giá : " + price);
        }
        ProductRespone productRespone = productRespository.findProductById(id);
        productRespone.setPrice(price);
        productRespone.setUrlFileAvatar("http://localhost:8080/uploads/" + productRespone.getUrlFileAvatar());
        return productRespone;
    }

    @Override
    public List<ProductRespone> findAllByCategory(String nameCategory) {
        return setPriceAndUrlImage(productRespository.findAllByCategory(nameCategory));
    }

    @Override
    public List<ProductRespone> findAllByName(String name) {
        String key = "%" + name + "%";
        return setPriceAndUrlImage(productRespository.findAllByName(key));
    }
}
