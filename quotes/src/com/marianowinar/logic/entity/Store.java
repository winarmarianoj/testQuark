package com.marianowinar.logic.entity;

import com.marianowinar.logic.entity.impl.Garment;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private Long storeId;
    private String name;
    private String address;
    private List<Garment> garmentList;
    private List<Seller> sellerList;
    private List<Quotes> quotesList;

    public Store(){}

    public Store(Long storeId, String name, String address, List<Garment> garmentList,
                 List<Seller> sellerList, List<Quotes> quotesList) {
        this.storeId = storeId;
        this.name = name;
        this.address = address;
        this.garmentList = garmentList;
        this.sellerList = sellerList;
        this.quotesList = quotesList;
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

    public List<Garment> getGarmentList() {
        return garmentList;
    }

    public void setGarmentList(List<Garment> garmentList) {
        if(garmentList == null)
            garmentList = new ArrayList<>();

        this.garmentList = garmentList;
    }

    public List<Seller> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<Seller> sellerList) {
        if(sellerList == null)
            sellerList = new ArrayList<>();

        this.sellerList = sellerList;
    }

    public List<Quotes> getQuotesList() {
        return quotesList;
    }

    public void setQuotesList(List<Quotes> quotesList) {
        if(quotesList == null)
            quotesList = new ArrayList<>();

        this.quotesList = quotesList;
    }
}
