package com.example.demo.services;

import com.example.demo.entities.SalesMan;
import com.example.demo.respositories.SalesManRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesManServiceImpl implements SalesManService{
    @Autowired
    private SalesManRespository salesManRespository;

    @Override
    public SalesMan findById(Long id) {
        return salesManRespository.findById(id).get();
    }

    @Override
    public SalesMan findByUser(Long idUser) {
        return salesManRespository.findByUserAccount(idUser);
    }
}
