package com.codex.busel.web.service.impl;

import com.codex.busel.web.dao.UserDao;
import com.codex.busel.web.model.User;
import com.codex.busel.web.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User merge(User user) {
        if (user.getUserId() == null) {
            user = userDao.create(user);
        } else {
            user = userDao.update(user);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User create(User u) {
        return userDao.create(u);
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public User find(Object id) {
        return null;
    }

    @Override
    public User update(User u) {
        return null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Query query = sessionFactory.getCurrentSession().createQuery("from user u where u.user_name=:username");
        query.setParameter("username", username);
        User result = (User) query.uniqueResult();

        if (result == null){
            throw new UsernameNotFoundException("username: " + username + " not found");
        }
        return result;
    }
}
