package com.marianowinar.persistance;

import java.util.List;

public interface IListPersistance<T> {

    List<T> getList();

    void add(T entity);

    void addList(List<T> entityList);

    int listSize();

    T search(Long index);

    boolean remove(Long index);
}
