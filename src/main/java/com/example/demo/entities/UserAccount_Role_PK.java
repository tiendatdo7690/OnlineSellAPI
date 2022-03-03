package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserAccount_Role_PK implements Serializable {

    private static final long serialVersionUID = -8376407037992970352L;
    @Column(name = "userAccountId")
    private Long userAccountId;

    @Column(name = "roleId")
    private Long roleId;

    public UserAccount_Role_PK(Long userAccountId, Long roleId) {
        this.userAccountId = userAccountId;
        this.roleId = roleId;
    }

    public UserAccount_Role_PK() {
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
