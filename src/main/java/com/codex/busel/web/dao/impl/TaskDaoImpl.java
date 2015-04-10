package com.codex.busel.web.dao.impl;

import com.codex.busel.web.dao.TaskDao;
import com.codex.busel.web.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional(readOnly = false)
    public void merge(Task task) {
        if (task.getId() == null) {
            em.persist(task);
        } else {
            em.merge(task);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return em.find(Task.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        Query query = em.createQuery("SELECT p FROM Task p");
        List<Task> projects = query.getResultList();
        return projects;
    }
}
