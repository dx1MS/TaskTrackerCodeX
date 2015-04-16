package com.codex.busel.web.service.impl;

import com.codex.busel.web.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private SessionFactory sessionFactory;

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
