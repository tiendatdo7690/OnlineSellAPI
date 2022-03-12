package com.example.demo.respositories;

import com.example.demo.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface AccountRespositories extends CrudRepository<UserAccount, Long> {

    UserAccount findUserAccountByUserName(String username);
}
