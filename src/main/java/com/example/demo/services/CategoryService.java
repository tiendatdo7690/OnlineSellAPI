package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entitiesRequest.CategoryRequest;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryService {

    Boolean saveCategory(CategoryRequest categoryRequest);

    List<CategoryRequest> findAll();

    Category findById(Long id);

    List<CategoryRequest> findAllCategoryByName(String name);
}
