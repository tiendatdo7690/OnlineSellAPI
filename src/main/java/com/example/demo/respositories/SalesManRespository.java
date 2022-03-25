package com.example.demo.respositories;

import com.example.demo.entities.SalesMan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SalesManRespository extends CrudRepository<SalesMan, Long> {

    @Query(value = "select s \n" +
            "from SalesMan s " +
            "where s.userAccount.id = :idUsser")
    SalesMan findByUserAccount(@Param("idUsser") Long idUsser);
}
