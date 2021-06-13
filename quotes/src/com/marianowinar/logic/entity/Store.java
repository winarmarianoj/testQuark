package com.marianowinar.logic.entity;

import com.marianowinar.logic.entity.impl.Garment;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private Long storeId;
    private String name;
    private String address;

    public Store(){}

    public Store(Long storeId, String name, String address) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
