package com.codex.busel.web.service.impl;

import com.codex.busel.web.dao.TaskDao;
import com.codex.busel.web.dao.impl.TaskDaoImpl;
import com.codex.busel.web.model.Task;
import com.codex.busel.web.service.TaskService;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public Task merge(Task task) {
        if (task.getTaskId() == null) {
            task = taskDao.create(task);
        } else {
            task = taskDao.update(task);
        }
        return task;
    }

    @Override
    public List<Task> findTasksByUserId(Long id) {
        //throw new RuntimeException("METHOD findTasksByUserId is not implemented");
        return taskDao.findTasksByUserId(id);
    }

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public Task create(Task t) {
        return taskDao.create(t);
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Task find(Object id) {
        return taskDao.find(id);
    }

    @Override
    public Task update(Task t) {
        return taskDao.update(t);
    }
}
