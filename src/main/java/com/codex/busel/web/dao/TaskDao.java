package com.codex.busel.web.dao;

import com.codex.busel.web.model.Task;

import java.util.List;

public interface TaskDao {

    void merge(Task project);

    Task findById(Long id);

    List<Task>  findAll();
}
