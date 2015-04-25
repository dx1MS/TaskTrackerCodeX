package com.codex.busel.web.dao;

import com.codex.busel.web.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{

    List<User> findDevelopers();

    List<User>  findAll();
//    void merge(User user);
//
//    List<Task> findAll();
    User findByName(String name);

}
