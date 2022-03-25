package com.example.demo.services;

import com.example.demo.entities.DeliveryProcess;
import com.example.demo.respositories.DeliveryProcessRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryProcessServiceImpl implements DeliveryProcessService{

    @Autowired
    private DeliveryProcessRespository deliveryProcessRespository;

    @Override
    public Boolean getIsSuccessByIdOrder(Long idOrder) {
        Boolean isSuccess = deliveryProcessRespository.getIsSuccessByIdOrder(idOrder);
        return isSuccess == null ? false : isSuccess;
    }

    @Override
    public Long getIdByOrder(Long idOrder) {
        return deliveryProcessRespository.getIdByOrder(idOrder);
    }

    //don't exist return true
    @Override
    public Boolean isExistDeliveryProcessByIdOrder(Long idOrder) {
        Boolean isExist = deliveryProcessRespository.getDeliveryProcessByIdOrder(idOrder)
                == null ? true :false;
        return isExist;
    }
}
