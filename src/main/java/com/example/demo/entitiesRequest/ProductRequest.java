package com.example.demo.entitiesRequest;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductRequest {

    private Long id;

    private String name;

    private String description;

    private int inventoryNumber;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date dateSell;

    private Boolean status;

    private Long idSalesMan;

    private Long idCategory;

    public ProductRequest() {
    }

    public ProductRequest(Long id, String name, String description, int inventoryNumber, Date dateSell, Boolean status, Long idSalesMan, Long idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inventoryNumber = inventoryNumber;
        this.dateSell = dateSell;
        this.status = status;
        this.idSalesMan = idSalesMan;
        this.idCategory = idCategory;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Date getDateSell() {
        return dateSell;
    }

    public void setDateSell(Date dateSell) {
        this.dateSell = dateSell;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getIdSalesMan() {
        return idSalesMan;
    }

    public void setIdSalesMan(Long idSalesMan) {
        this.idSalesMan = idSalesMan;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }
}
