package com.example.demo.respositories;

import com.example.demo.entities.Category;
import com.example.demo.entitiesRequest.CategoryRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRespository extends CrudRepository<Category, Long> {

    List<Category> findAllBy();

    @Query(value = "select  new com.example.demo.entitiesRequest.CategoryRequest(c.id,c.name) \n" +
            "from Category c")
    List<CategoryRequest> findAllCategory();

    @Query(value = "select  new com.example.demo.entitiesRequest.CategoryRequest(c.id,c.name) \n" +
            "from Category c " +
            "where c.name = :name")
    List<CategoryRequest> findAllCategoryByName(@Param("name") String name);
}
