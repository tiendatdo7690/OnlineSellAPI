package com.example.demo.services;

import com.example.demo.entities.DeliveryProcess;
import org.springframework.data.repository.query.Param;

public interface DeliveryProcessService {

    Boolean getIsSuccessByIdOrder(Long idOrder);

    Long getIdByOrder(Long idOrder);

    Boolean isExistDeliveryProcessByIdOrder(Long idOrder);
}
