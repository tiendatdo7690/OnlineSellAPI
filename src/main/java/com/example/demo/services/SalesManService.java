package com.example.demo.services;

import com.example.demo.entities.SalesMan;

public interface SalesManService {
    SalesMan findById(Long id);
    SalesMan findByUser(Long idUser);
}
