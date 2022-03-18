package com.example.demo.controllers;

import com.example.demo.entities.Role;
import com.example.demo.entities.UserAccount;
import com.example.demo.entitiesAPI.RoleAPI;
import com.example.demo.entitiesAPI.UserAccountAPI;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserAccount_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserAccount_RoleService userAccount_roleService;

    @RequestMapping(value = "findbyusername/{username}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccountAPI> findByUserName(@PathVariable String username) {

        try {
            UserAccount userAccount = accountService.findUserAccountByUserName(username);
            return new ResponseEntity<UserAccountAPI>(new UserAccountAPI(userAccount.getId(),userAccount.getUserName(),
                    userAccount.getPassWord(),userAccount.getStatus()),
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<UserAccountAPI>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findrolebyusername/{username}" ,method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleAPI>> findRoleByUserName(@PathVariable String username) {

        try {
            UserAccount userAccount = accountService.findUserAccountByUserName(username);
            List<RoleAPI> roles = new ArrayList<RoleAPI>();
            userAccount_roleService.findAllByUserAccount(userAccount).forEach(e -> {
                roles.add(new RoleAPI(e.getRole().getId(),e.getRole().getName()));
            });
            return new ResponseEntity<List<RoleAPI>>(roles,
                    HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<RoleAPI>>(HttpStatus.BAD_REQUEST);
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
