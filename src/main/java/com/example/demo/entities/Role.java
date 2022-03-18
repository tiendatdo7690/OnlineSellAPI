package com.example.demo.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

    private static final long serialVersionUID = 5138627120285954277L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "name", length = 255)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "role")
    private Set<UserAccount_Role> userAccount_roles = new HashSet<UserAccount_Role>(0);

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserAccount_Role> getUserAccount_roles() {
        return userAccount_roles;
    }

    public void setUserAccount_roles(Set<UserAccount_Role> userAccount_roles) {
        this.userAccount_roles = userAccount_roles;
    }
}
