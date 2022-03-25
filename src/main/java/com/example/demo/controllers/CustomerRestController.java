package com.example.demo.controllers;

import com.example.demo.entities.UserAccount;
import com.example.demo.entitiesAPI.UserAccountAPI;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "getidbyuser/{username}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getIdByUser(@PathVariable String username) {

        try {
            return new ResponseEntity<String>(customerService.getIdByUser(username).toString(),
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
