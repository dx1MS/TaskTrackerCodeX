package com.codex.busel.web.dao;

import com.codex.busel.web.model.Task;

import java.util.List;

public interface TaskDao extends GenericDao<Task> {

    void merge(Task project);

    List<Task> findTasksByUserId(Long id);

    List<Task>  findAll();
}
