package com.example.demo.respositories;

import com.example.demo.entities.Address;
import com.example.demo.entities.Customer;
import com.example.demo.entitiesRequest.AddressRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRespository extends CrudRepository<Address, Long> {

    @Query(value = "select  new com.example.demo.entitiesRequest.AddressRequest(a.id,a.address) \n" +
            "from Address a inner join Customer c on a.customer.id = c.id " +
            "where c.id = :idCustomer")
    List<AddressRequest> findAllByCustomer(@Param("idCustomer") Long idCustomer);
}
