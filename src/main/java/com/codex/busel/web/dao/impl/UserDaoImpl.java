package com.codex.busel.web.dao.impl;

import com.codex.busel.web.dao.UserDao;
import com.codex.busel.web.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @Override
    public List<User> findDevelopers() {
        return em.createQuery("select u from User u where u.role = 'DEVELOPER'", User.class).getResultList();
    }
}
