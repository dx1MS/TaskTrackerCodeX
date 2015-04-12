package com.codex.busel.web.service;

import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;

import java.util.List;

public interface TaskService {
    Task merge(Task task);

    List<Task> findTasksByUserId(Long id);

    List<Task>  findAll();

//    Task create(Task t);
//
//    void delete(Object id);
//
//    Task find(Object id);

//    Task update(Task t);
}
