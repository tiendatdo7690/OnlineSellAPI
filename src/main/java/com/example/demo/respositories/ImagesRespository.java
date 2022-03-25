package com.example.demo.respositories;

import com.example.demo.entities.Image;
import com.example.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImagesRespository extends CrudRepository<Image, Long> {
    List<Image> findAllByProduct(Product product);
}
