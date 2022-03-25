package com.example.demo.controllers;

import com.example.demo.entitiesRequest.OrderProductShow;
import com.example.demo.entitiesRequest.ProcessResquest;
import com.example.demo.services.DeliveryProcessService;
import com.example.demo.services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/process")
public class ProcessRestController {

    @Autowired
    private ProcessService processService;
    @Autowired
    private DeliveryProcessService deliveryProcessService;
    @RequestMapping(value = "findallbyoder/{idorder}" ,method = RequestMethod.GET,
            produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProcessResquest>> findAllByDeliveryProcess(@PathVariable Long idorder) {

        try {

            Long iddeliveryprocess = deliveryProcessService.getIdByOrder(idorder);
            return new ResponseEntity<List<ProcessResquest>>(processService.findAllByDeliveryProcess(iddeliveryprocess),
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<ProcessResquest>>(HttpStatus.BAD_REQUEST);
        }
    }
}
