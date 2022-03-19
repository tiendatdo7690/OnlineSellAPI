package com.example.demo.services;

import com.example.demo.entitiesRequest.CategoryRequest;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.respositories.AccountRespository;
import com.example.demo.respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProductService {

    Boolean saveProduct(ProductRequest productRequest);

}
