package com.example.demo.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Process")
public class Process implements Serializable {

    private static final long serialVersionUID = 6947035474226377149L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "name", length = 255)
    private String name;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "deliveryProcess_id" , foreignKey= @ForeignKey(name = "Fk_deliveryProcess_Process"), nullable = true)
    private DeliveryProcess deliveryProcess;

    public Process(Long id, String name, Date date, DeliveryProcess deliveryProcess) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.deliveryProcess = deliveryProcess;
    }

    public Process() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DeliveryProcess getDeliveryProcess() {
        return deliveryProcess;
    }

    public void setDeliveryProcess(DeliveryProcess deliveryProcess) {
        this.deliveryProcess = deliveryProcess;
    }
}
