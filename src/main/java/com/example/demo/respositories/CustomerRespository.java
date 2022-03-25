package com.example.demo.respositories;

import com.example.demo.entities.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRespository extends CrudRepository<Customer, Long> {

    @Query(value = "select  c.id \n" +
            "from Customer c inner join UserAccount u on c.userAccount.id = u.id " +
            "where u.userName = :username")
    Long getIdByUser(@Param("username") String username);
}
