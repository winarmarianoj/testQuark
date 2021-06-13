package com.marianowinar.persistance.impl;

import com.marianowinar.logic.entity.Quotes;
import com.marianowinar.logic.entity.Seller;
import com.marianowinar.persistance.IListPersistance;

import java.util.ArrayList;
import java.util.List;

public class ListQuotes implements IListPersistance<Quotes> {
    private List<Quotes> quotesList;

    @Override
    public List<Quotes> getList() {
        if(quotesList == null) quotesList = new ArrayList<>();

        return quotesList;
    }

    @Override
    public void add(Quotes entity) {
        if(quotesList == null) quotesList = new ArrayList<>();

        quotesList.add(entity);
    }

    @Override
    public void addList(List<Quotes> entityList){
        if(quotesList == null) quotesList = new ArrayList<>();

        quotesList.addAll(entityList);
    }

    @Override
    public int listSize() {
        if(quotesList == null) quotesList = new ArrayList<>();

        return quotesList.size();
    }

    @Override
    public Quotes search(Long index) {
        if(index < 0 || index >= listSize()) return null;

        Quotes quotes = null;
        for(Quotes ele : getList()){
            if(ele.getQuotesId() == index)
                quotes = ele;
        }
        return quotes;
    }

    @Override
    public boolean remove(Long index) {
        if(index < 0 || index >= listSize()) return false;

        quotesList.remove(index);
        return true;
    }
}
