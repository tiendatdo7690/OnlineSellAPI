package com.example.demo.services;

import com.example.demo.entities.Image;
import com.example.demo.entities.Product;
import com.example.demo.respositories.ImagesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImagesRespository imagesRespository;


    @Override
    public void saveAll(List<Image> images) {
        imagesRespository.saveAll(images);
    }

    @Override
    public void save(Image image) {
        imagesRespository.save(image);
    }

    @Override
    public List<Image> findAllByProduct(Product product) {
        return imagesRespository.findAllByProduct(product);
    }
}
