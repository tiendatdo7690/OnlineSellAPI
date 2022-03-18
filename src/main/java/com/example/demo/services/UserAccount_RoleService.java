package com.example.demo.services;

import com.example.demo.entities.UserAccount;
import com.example.demo.entities.UserAccount_Role;

import java.util.List;

public interface UserAccount_RoleService {

    List<UserAccount_Role> findAllByUserAccount(UserAccount useraccount);
}
