package com.master.transaction.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction_demo_payment")
public class Payment {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type", nullable = false, length = 10)
    private String type;

    public Payment(String type) {
        this.type = type;
    }

    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

}
