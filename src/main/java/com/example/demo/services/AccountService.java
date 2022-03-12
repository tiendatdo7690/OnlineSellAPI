package com.example.demo.services;

import com.example.demo.entities.UserAccount;

public interface AccountService {

    UserAccount save(UserAccount userAccount);
    UserAccount findUserAccountByUserName(String username);

}
