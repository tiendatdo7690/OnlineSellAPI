package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserAccount_Role")
public class UserAccount_Role implements Serializable {

    private static final long serialVersionUID = 258106953171136814L;
    @EmbeddedId
    private  UserAccount_Role_PK id;

    @MapsId("userAccountId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "userAccountId" , foreignKey= @ForeignKey(name = "Fk_UserAccount_UserAccount_Role"), nullable = true)
    private UserAccount userAccount;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "roleId" , foreignKey= @ForeignKey(name = "Fk_Role_UserAccount_Role"), nullable = true)
    private Role role;


    public UserAccount_Role(UserAccount_Role_PK id, UserAccount userAccount, Role role) {
        this.id = id;
        this.userAccount = userAccount;
        this.role = role;
    }

    public UserAccount_Role() {
    }

    public UserAccount_Role_PK getId() {
        return id;
    }

    public void setId(UserAccount_Role_PK id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
