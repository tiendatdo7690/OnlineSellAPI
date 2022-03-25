package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.entitiesRequest.*;
import com.example.demo.services.DeliveryProcessService;
import com.example.demo.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orderproduct")
public class OrderProductRestController {

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private DeliveryProcessService deliveryProcessService;

    @RequestMapping(value = "saveallorderproduct" ,method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveAllOrderProduct(@RequestBody List<OderProductResquest> oderProductResquests) {

        try {
            orderProductService.saveAll(oderProductResquests);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findallbycustomer/{idcustomer}" ,method = RequestMethod.GET,
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderProductShow>> findByCustomer(@PathVariable Long idcustomer) {

        try {

            List<OrderProductShow> orderProductShows =  orderProductService.findAllByCustomer(idcustomer);
            for (OrderProductShow orderProductShow : orderProductShows){
                orderProductShow.setSuccess(deliveryProcessService.getIsSuccessByIdOrder(orderProductShow.getId()));
            }
            System.out.println(orderProductShows);
            return new ResponseEntity<List<OrderProductShow>>(orderProductShows,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<OrderProductShow>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "deleteorder/{idorder}" ,method = RequestMethod.DELETE,
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long idorder) {

        try {

            Boolean isExist = deliveryProcessService.isExistDeliveryProcessByIdOrder(idorder);
            Boolean isDelete = orderProductService.deleteOrder(idorder,isExist);
            return new ResponseEntity<Boolean>(isDelete,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
    }
}
