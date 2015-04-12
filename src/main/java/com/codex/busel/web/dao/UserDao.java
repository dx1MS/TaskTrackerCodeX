package com.codex.busel.web.dao;

import com.codex.busel.web.model.Task;
import com.codex.busel.web.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{

    List<User> findDevelopers();

//    void merge(User user);
//
//    List<Task> findAll();

}
