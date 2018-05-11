package com.master.demo.model;

import javax.persistence.*;
import java.util.Set;

/**
 * one-2-many   User - Department
 */
@Entity
@Table(name = "t_demo_cascade_department")
public class Department {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Transient
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}