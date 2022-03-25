package com.example.demo.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DeliveryProcess")
public class DeliveryProcess implements Serializable {

    private static final long serialVersionUID = -1118963292820429228L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "isSuccess")
    private Boolean isSuccess;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "intendedDeliveryDate")
    private Date intendedDeliveryDate;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "order_id" , foreignKey= @ForeignKey(name = "Fk_order_DeliveryProcess"), nullable = true,
            unique = true)
    private OrderProduct order;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "deliveryProcess")
    private Set<Process> processes = new HashSet<Process>(0);

    public DeliveryProcess(Long id, Boolean isSuccess, Date intendedDeliveryDate, OrderProduct order, Set<Process> processes) {
        this.id = id;
        this.isSuccess = isSuccess;
        this.intendedDeliveryDate = intendedDeliveryDate;
        this.order = order;
        this.processes = processes;
    }

    public DeliveryProcess() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Date getIntendedDeliveryDate() {
        return intendedDeliveryDate;
    }

    public void setIntendedDeliveryDate(Date intendedDeliveryDate) {
        this.intendedDeliveryDate = intendedDeliveryDate;
    }

    public OrderProduct getOrder() {
        return order;
    }

    public void setOrder(OrderProduct order) {
        this.order = order;
    }

    public Set<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(Set<Process> processes) {
        this.processes = processes;
    }
}
