package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entitiesRequest.CategoryRequest;
import com.example.demo.respositories.AccountRespository;
import com.example.demo.respositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRespository categoryRespository;


    @Override
    public Boolean saveCategory(CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest.getName());
        return categoryRespository.save(category) != null;
    }

    @Override
    public List<CategoryRequest> findAll() {

        return categoryRespository.findAllCategory();
    }
}
