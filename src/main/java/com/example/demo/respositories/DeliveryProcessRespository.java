package com.example.demo.respositories;

import com.example.demo.entities.DeliveryProcess;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryProcessRespository extends CrudRepository<DeliveryProcess, Long> {

    @Query(value = "select  d.isSuccess \n" +
            "from DeliveryProcess d " +
            "where d.order.id = :idOrder")
    Boolean getIsSuccessByIdOrder(@Param("idOrder") Long idOrder);

    @Query(value = "select  d \n" +
            "from DeliveryProcess d " +
            "where d.order.id = :idOrder")
    DeliveryProcess getDeliveryProcessByIdOrder(@Param("idOrder") Long idOrder);

    @Query(value = "select  d.id \n" +
            "from DeliveryProcess d " +
            "where d.order.id = :idOrder")
    Long getIdByOrder(@Param("idOrder") Long idOrder);
}
