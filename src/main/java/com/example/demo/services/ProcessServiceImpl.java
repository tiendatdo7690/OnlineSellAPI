package com.example.demo.services;

import com.example.demo.entitiesRequest.ProcessResquest;
import com.example.demo.respositories.ProcessRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService{
    @Autowired
    private ProcessRespository processRespository;
    @Override
    public List<ProcessResquest> findAllByDeliveryProcess(Long idDeliveryProcess) {
        return processRespository.findAllByDeliveryProcess(idDeliveryProcess);
    }
}
