package com.example.demo.respositories;

import com.example.demo.entities.OrderProduct;
import com.example.demo.entitiesRequest.OrderProductShow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProductRespository extends CrudRepository<OrderProduct, Long> {

    @Query(value = "select  new com.example.demo.entitiesRequest.OrderProductShow(o.id,o.date,o.quantity," +
            " o.product.name,o.customer.id,o.address.address) \n" +
            "from Customer c inner join OrderProduct o on c.id = o.customer.id " +
            "where c.id = :idCustomer " +
            "order by o.date desc ")
    List<OrderProductShow> findAllByCustomer(@Param("idCustomer") Long idCustomer);
}
