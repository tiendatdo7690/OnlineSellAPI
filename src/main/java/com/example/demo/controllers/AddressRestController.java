package com.example.demo.controllers;


import com.example.demo.entities.Address;
import com.example.demo.entities.UserAccount;
import com.example.demo.entitiesAPI.UserAccountAPI;
import com.example.demo.entitiesRequest.AddressRequest;
import com.example.demo.respositories.AddressRespository;
import com.example.demo.services.AddressService;
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
@RequestMapping("api/address")
public class AddressRestController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "findallbycustomer/{idcustomer}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AddressRequest>> findByUserName(@PathVariable Long idcustomer) {

        try {

            return new ResponseEntity<List<AddressRequest>>(addressService.findAllByCustomer(idcustomer),
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<AddressRequest>>(HttpStatus.BAD_REQUEST);
        }
    }
}
