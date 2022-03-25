package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.SalesMan;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.entitiesRequest.ProductRespone;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product saveProduct(ProductRequest productRequest, String urlAvatar, Category category, SalesMan salesMan);

    List<ProductRespone> findAll() throws IOException;

    ProductRespone findProductById(Long id);

    List<ProductRespone> findAllByCategory(String nameCategory);

    List<ProductRespone> findAllByName(String name);
}
