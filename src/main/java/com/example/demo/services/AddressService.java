package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.entities.Customer;
import com.example.demo.entitiesRequest.AddressRequest;

import java.util.List;

public interface AddressService {

    List<AddressRequest> findAllByCustomer(Long idCustomer);
}
