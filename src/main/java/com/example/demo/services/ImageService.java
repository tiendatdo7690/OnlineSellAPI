package com.example.demo.services;

import com.example.demo.entities.Image;
import com.example.demo.entities.Product;

import java.util.List;

public interface ImageService {

    void saveAll(List<Image> images);

    void save(Image image);

    List<Image> findAllByProduct(Product product);
}
