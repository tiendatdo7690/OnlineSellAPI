package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.SalesMan;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRespository productRespository;

    @Override
    public Boolean saveProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getInventoryNumber(),
                productRequest.getDateSell(),productRequest.getStatus(),new SalesMan(productRequest.getIdSalesMan()),
                new Category(productRequest.getIdCategory()));
        return productRespository.save(product) != null;
    }
}
