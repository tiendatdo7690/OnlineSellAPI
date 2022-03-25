package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.entities.OrderProduct;
import com.example.demo.entitiesRequest.OderProductResquest;
import com.example.demo.entitiesRequest.OrderProductShow;

import java.util.List;

public interface OrderProductService {

    void saveAll(List<OderProductResquest> oderProductResquests);
    List<OrderProductShow> findAllByCustomer(Long idCustomer);
    Boolean deleteOrder(Long idOrder, Boolean isDeliveryProcessNull);
}
