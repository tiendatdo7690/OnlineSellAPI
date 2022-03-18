package com.example.demo.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UserAccount")
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 6102618986563947946L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "userName", length = 255)
    private String userName;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "passWord", length = 255)
    private String passWord;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "status")
    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "userAccount")
    private Set<UserAccount_Role> userAccount_roles = new HashSet<UserAccount_Role>(0);

    public UserAccount(Long id, String userName, String passWord, Boolean status) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
    }

    public UserAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<UserAccount_Role> getUserAccount_roles() {
        return userAccount_roles;
    }

    public void setUserAccount_roles(Set<UserAccount_Role> userAccount_roles) {
        this.userAccount_roles = userAccount_roles;
    }
}
