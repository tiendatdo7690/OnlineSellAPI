package com.example.demo.services;

import com.example.demo.entitiesRequest.ProcessResquest;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcessService {

    List<ProcessResquest> findAllByDeliveryProcess(Long idDeliveryProcess);
}
