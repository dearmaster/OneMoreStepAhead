package com.master.demo.model;

import javax.persistence.*;
import java.util.Set;

/**
 * many-2-many  Entitlement - Group
 */
@Entity
@Table(name = "t_demo_cascade_group")
public class Group {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    @Transient
    private Set<Entitlement> entitlements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Entitlement> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(Set<Entitlement> entitlements) {
        this.entitlements = entitlements;
    }
}