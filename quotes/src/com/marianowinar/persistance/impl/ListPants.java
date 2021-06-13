package com.marianowinar.persistance.impl;

import com.marianowinar.logic.entity.Pants;
import com.marianowinar.logic.entity.Quotes;
import com.marianowinar.persistance.IListPersistance;

import java.util.ArrayList;
import java.util.List;

public class ListPants implements IListPersistance<Pants> {
    private List<Pants> pantsList;

    @Override
    public List<Pants> getList() {
        if(pantsList == null) pantsList = new ArrayList<>();

        return pantsList;
    }

    @Override
    public void add(Pants entity) {
        if(pantsList == null) pantsList = new ArrayList<>();

        pantsList.add(entity);
    }

    @Override
    public void addList(List<Pants> entityList) {
        if(pantsList == null) pantsList = new ArrayList<>();

        pantsList.addAll(entityList);
    }

    @Override
    public int listSize() {
        if(pantsList == null) pantsList = new ArrayList<>();

        return pantsList.size();
    }

    @Override
    public Pants search(Long index) {
        if(index < 0 || index >= listSize()) return null;

        Pants pants = null;
        for(Pants ele : getList()){
            if(ele.getGarmentId() == index)
                pants = ele;
        }
        return pants;
    }

    @Override
    public boolean remove(Long index) {
        if(index < 0 || index >= listSize()) return false;

        pantsList.remove(index);
        return true;
    }
}
