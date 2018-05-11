package com.master.demo.model;

import javax.persistence.*;

/**
 * one-2-one    Group - User
 * one-2-many   User - Department
 */
@Entity
@Table(name = "t_demo_cascade_user")
public class User {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String name;
    @Column(nullable = false)
    private Gender gender;
    @Column(length = 200)
    private String address;
    @Column(name = "email", length = 20)
    private String email;
    @Column(name = "phone", length = 20)
    private String phone;

    @Transient
    private Group group;
    @Transient
    private Department department;

    public User() {
    }

    public User(String name, Gender gender, String address, String email, String phone) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}