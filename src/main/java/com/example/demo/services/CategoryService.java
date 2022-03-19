package com.example.demo.services;

import com.example.demo.entitiesRequest.CategoryRequest;

import java.util.List;

public interface CategoryService {

    Boolean saveCategory(CategoryRequest categoryRequest);

    List<CategoryRequest> findAll();
}
