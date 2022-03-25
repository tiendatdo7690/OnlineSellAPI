package com.example.demo.entitiesRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductRespone {

    private Long id;

    private String name;

    private String description;

    private int inventoryNumber;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date dateSell;

    private Boolean status;

    private Long idSalesMan;

    private Long idCategory;

    private Double price;

    private String urlFileAvatar;

    private List<String> images;


    public ProductRespone(Long id, String name, String description, int inventoryNumber, Date dateSell, Boolean status,
                          Long idSalesMan, Long idCategory, String urlFileAvatar) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inventoryNumber = inventoryNumber;
        this.dateSell = dateSell;
        this.status = status;
        this.idSalesMan = idSalesMan;
        this.idCategory = idCategory;
        this.urlFileAvatar = urlFileAvatar;
        images = new ArrayList<String>();
    }

    public ProductRespone() {
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

    public String getUrlFileAvatar() {
        return urlFileAvatar;
    }

    public void setUrlFileAvatar(String urlFileAvatar) {
        this.urlFileAvatar = urlFileAvatar;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
