package com.codex.busel.web.dao.impl;

import com.codex.busel.web.dao.ProjectDao;
import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProjectDaoImpl extends GenericDaoImpl<Project> implements ProjectDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Task> findTasksByProjectId(Long id) {
        return em.find(Project.class, id).getTasks();
    }

    @Override
    public List<Project> findAll() {
        Query query = em.createQuery("SELECT p FROM Project p");
        List<Project> projects = query.getResultList();
        return projects;
    }
}