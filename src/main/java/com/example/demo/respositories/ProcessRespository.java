package com.example.demo.respositories;


import com.example.demo.entities.Process;
import com.example.demo.entitiesRequest.ProcessResquest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcessRespository extends CrudRepository<Process, Long> {

    @Query(value = "select  new com.example.demo.entitiesRequest.ProcessResquest(c.id,c.name,c.date )" +
            "from Process c " +
            "where c.deliveryProcess.id = :idDeliveryProcess")
    List<ProcessResquest> findAllByDeliveryProcess(@Param("idDeliveryProcess") Long idDeliveryProcess);
}
