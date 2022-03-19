package com.example.demo.respositories;

import com.example.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRespository extends CrudRepository<Product, Long> {

}
