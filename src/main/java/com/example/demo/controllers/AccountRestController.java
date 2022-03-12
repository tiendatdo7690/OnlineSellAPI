package com.example.demo.controllers;

import com.example.demo.entities.UserAccount;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "findbyusername/{username}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccount> findByUserName(@PathVariable String username) {

        try {
            //System.out.printf(username);
            return new ResponseEntity<UserAccount>(accountService.findUserAccountByUserName(username),
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<UserAccount>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findbcrypt/{pass}" ,method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> findBCrypt(@PathVariable String pass) {

        try {
            String hash = new BCryptPasswordEncoder().encode(pass);
            return new ResponseEntity<String>(hash,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "hello" ,method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> hello() {

        try {

            return new ResponseEntity<String>("hello",
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
