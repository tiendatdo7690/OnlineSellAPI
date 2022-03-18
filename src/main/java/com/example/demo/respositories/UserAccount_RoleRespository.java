package com.example.demo.respositories;

import com.example.demo.entities.UserAccount;
import com.example.demo.entities.UserAccount_Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAccount_RoleRespository extends CrudRepository<UserAccount_Role, Long> {

    List<UserAccount_Role> findAllByUserAccount(UserAccount useraccount);
}
