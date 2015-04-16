package com.codex.busel.web.dao.impl;

import com.codex.busel.web.dao.TaskDao;
import com.codex.busel.web.model.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task> implements TaskDao {

    @Override
    public void merge(Task task) {
        if (task.getTaskId() == null) {
            em.persist(task);
        } else {
            em.merge(task);
        }
    }

    @Override
    public List<Task> findTasksByUserId(Long id) {
        throw new RuntimeException("METHOD findTasksByUserId is not implemented");
        //return em.find(User.class, id).getTasks();
    }

    @Override
    public List<Task> findAll() {
        Query query = em.createQuery("SELECT p FROM Task p");
        List<Task> projects = query.getResultList();
        return projects;
    }
}
