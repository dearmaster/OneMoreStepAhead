package com.master.demo.model;

import javax.persistence.*;
import java.util.Set;

/**
 * many-2-many  Entitlement - Group
 */
@Entity
@Table(name = "t_demo_cascade_entitlement")
public class Entitlement {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 20)
    private String name;

    @Transient
    private Set<Group> groups;

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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}