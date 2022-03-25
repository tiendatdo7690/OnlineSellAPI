package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.entities.Customer;
import com.example.demo.entitiesRequest.AddressRequest;
import com.example.demo.respositories.AddressRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRespository addressRespository;

    @Override
    public List<AddressRequest> findAllByCustomer(Long idCustomer) {
        return addressRespository.findAllByCustomer(idCustomer);
    }
}
