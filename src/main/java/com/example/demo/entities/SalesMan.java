package com.example.demo.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SalesMan")
public class SalesMan implements Serializable {

    private static final long serialVersionUID = -7318055287285097192L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "name", length = 255)
    private String name;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "birthDay")
    private Date birthDay;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "phone", length = 255)
    private String phone;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "urlImage", length = 255)
    private String urlImage;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "sex")
    private Boolean sex;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "nationality", length = 255)
    private String nationality;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "email", length = 255)
    private String email;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "address", length = 255)
    private String address;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "salesMan")
    private Set<Product> products = new HashSet<Product>(0);

    public SalesMan(Long id, String name, Date birthDay, String phone, String urlImage, Boolean sex, String nationality,
                    String email, String address, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.urlImage = urlImage;
        this.sex = sex;
        this.nationality = nationality;
        this.email = email;
        this.address = address;
        this.products = products;
    }

    public SalesMan() {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
