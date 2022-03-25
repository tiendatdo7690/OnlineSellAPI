package com.example.demo.services;

import com.example.demo.respositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRespository customerRespository;
    @Override
    public Long getIdByUser(String username) {
        return customerRespository.getIdByUser(username);
    }
}
