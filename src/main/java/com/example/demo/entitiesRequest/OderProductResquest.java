package com.example.demo.entitiesRequest;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OderProductResquest {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date date;

    private int quantity;

    private Long idProduct;

    private Long idCustomer;

    private Long idAddress;

    public OderProductResquest(Long id, Date date, int quantity, Long idProduct, Long idCustomer, Long idAddress) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
    }

    public OderProductResquest() {
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

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}
