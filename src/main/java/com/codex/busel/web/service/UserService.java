package com.codex.busel.web.service;

import com.codex.busel.web.model.User;

import java.util.List;

public interface UserService {
    User merge(User user);

    List<User> findAll();

    User create(User u);

    void delete(Object id);

    User find(Object id);

    User update(User u);
}
