package com.master.demo.model;

public enum Gender {

    M("男"),F("女");

    private String description;

    Gender(String description) {
        this.description = description;
    }

}