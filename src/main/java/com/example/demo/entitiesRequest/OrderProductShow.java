package com.example.demo.entitiesRequest;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderProductShow {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date date;

    private int quantity;

    private String nameProduct;

    private Long idCustomer;

    private String address;

    private Boolean success;

    public OrderProductShow() {
    }

    public OrderProductShow(Long id, Date date, int quantity, String nameProduct, Long idCustomer, String address) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.idCustomer = idCustomer;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
