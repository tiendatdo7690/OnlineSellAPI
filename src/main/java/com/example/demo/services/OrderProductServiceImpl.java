package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.entities.Customer;
import com.example.demo.entities.OrderProduct;
import com.example.demo.entities.Product;
import com.example.demo.entitiesRequest.OderProductResquest;
import com.example.demo.entitiesRequest.OrderProductShow;
import com.example.demo.respositories.OrderProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    @Autowired
    private OrderProductRespository orderProductRespository;

    @Override
    public void saveAll(List<OderProductResquest> oderProductResquests) {
        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        for(OderProductResquest oderProductResquest : oderProductResquests){
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(oderProductResquest.getQuantity());
            orderProduct.setDate(oderProductResquest.getDate());
            orderProduct.setAddress(new Address(oderProductResquest.getIdAddress()));
            orderProduct.setCustomer(new Customer(oderProductResquest.getIdCustomer()));
            orderProduct.setProduct(new Product(oderProductResquest.getIdProduct()));

            orderProducts.add(orderProduct);
        }
        orderProductRespository.saveAll(orderProducts);
    }

    @Override
    public List<OrderProductShow> findAllByCustomer(Long idCustomer) {
        return orderProductRespository.findAllByCustomer(idCustomer);
    }

    @Override
    public Boolean deleteOrder(Long idOrder, Boolean isDeliveryProcessNull) {

        if (isDeliveryProcessNull){
            orderProductRespository.delete(new OrderProduct(idOrder));
            return true;
        }
        return false;
    }
}
