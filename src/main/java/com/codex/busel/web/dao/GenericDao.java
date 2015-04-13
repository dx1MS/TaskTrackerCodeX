package com.codex.busel.web.dao;

public interface GenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);
}