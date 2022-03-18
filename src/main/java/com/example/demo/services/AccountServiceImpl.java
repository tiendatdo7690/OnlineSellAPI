package com.example.demo.services;

import com.example.demo.entities.UserAccount;
import com.example.demo.respositories.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRespository accountRespositories;

    @Override
    public UserAccount save(UserAccount userAccount) {
        return accountRespositories.save(userAccount);
    }

    @Override
    public UserAccount findUserAccountByUserName(String username) {
        return accountRespositories.findUserAccountByUserName(username);
    }
}
