package com.marianowinar.persistance.impl;

import com.marianowinar.logic.entity.Pants;
import com.marianowinar.logic.entity.Shirt;
import com.marianowinar.persistance.IListPersistance;

import java.util.ArrayList;
import java.util.List;

public class ListShirt implements IListPersistance<Shirt> {

    private List<Shirt> shirtList;
    @Override
    public List<Shirt> getList() {
        if(shirtList == null) shirtList = new ArrayList<>();

        return shirtList;
    }

    @Override
    public void add(Shirt entity) {
        if(shirtList == null) shirtList = new ArrayList<>();

        shirtList.add(entity);
    }

    @Override
    public void addList(List<Shirt> entityList) {
        if(shirtList == null) shirtList = new ArrayList<>();

        shirtList.addAll(entityList);
    }

    @Override
    public int listSize() {
        if(shirtList == null) shirtList = new ArrayList<>();

        return shirtList.size();
    }

    @Override
    public Shirt search(Long index) {
        if(index < 0 || index >= listSize()) return null;

        Shirt shirt = null;
        for(Shirt ele : getList()){
            if(ele.getGarmentId() == index)
                shirt = ele;
        }
        return shirt;
    }

    @Override
    public boolean remove(Long index) {
        if(index < 0 || index >= listSize()) return false;

        shirtList.remove(index);
        return true;
    }
}
