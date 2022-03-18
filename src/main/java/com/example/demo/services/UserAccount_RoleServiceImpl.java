package com.example.demo.services;

import com.example.demo.entities.UserAccount;
import com.example.demo.entities.UserAccount_Role;
import com.example.demo.respositories.UserAccount_RoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccount_RoleServiceImpl implements UserAccount_RoleService{

    @Autowired
    private UserAccount_RoleRespository userAccount_roleRespository;


    @Override
    public List<UserAccount_Role> findAllByUserAccount(UserAccount useraccount) {
        return userAccount_roleRespository.findAllByUserAccount(useraccount);
    }
}
