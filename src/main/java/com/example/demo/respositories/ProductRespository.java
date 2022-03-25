package com.example.demo.respositories;

import com.example.demo.entities.Image;
import com.example.demo.entities.Price;
import com.example.demo.entities.Product;
import com.example.demo.entitiesRequest.ProductRequest;
import com.example.demo.entitiesRequest.ProductRespone;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRespository extends CrudRepository<Product, Long> {

    @Query(value = "select  new com.example.demo.entitiesRequest.ProductRespone(p.id, " +
            "p.name, p.description, p.inventoryNumber, p.dateSell, " +
            "p.status, p.salesMan.id, p.category.id, p.urlAvatar) \n" +
            "from Product p")
    List<ProductRespone> findAllBy();

    @Query(value = "select  new com.example.demo.entitiesRequest.ProductRespone(p.id, " +
            "p.name, p.description, p.inventoryNumber, p.dateSell, " +
            "p.status, p.salesMan.id, p.category.id, p.urlAvatar) \n" +
            "from Product p " +
            "where p.category.name = :name")
    List<ProductRespone> findAllByCategory(@Param("name") String nameCategory);

    @Query(value = "select  new com.example.demo.entitiesRequest.ProductRespone(p.id, " +
            "p.name, p.description, p.inventoryNumber, p.dateSell, " +
            "p.status, p.salesMan.id, p.category.id, p.urlAvatar) \n" +
            "from Product p " +
            "where p.name like :name")
    List<ProductRespone> findAllByName(@Param("name") String name);

    @Query(value = "select  p.urlAvatar \n" +
            "from Product p " +
            "where p.id = :id")
    String getAvatar(@Param("id") Long id);

    @Query(value = "select  p.images \n" +
            "from Product p " +
            "where p.id = :id")
    List<Image> getImages(@Param("id") Long id);

    @Query(value = "select  new com.example.demo.entitiesRequest.ProductRespone(p.id, " +
            "p.name, p.description, p.inventoryNumber, p.dateSell, " +
            "p.status, p.salesMan.id, p.category.id, p.urlAvatar) \n" +
            "from Product p " +
            "where p.id = :id")
    ProductRespone findProductById(@Param("id") Long id);

    @Query(value = "select pri \n" +
            "from Product pro inner join  Price pri on pro.id = pri.product.id " +
            "where pro.id = :id " +
            "order by pri.date desc ")
    List<Price> getPriceOfProduct(@Param("id") Long id);
}
