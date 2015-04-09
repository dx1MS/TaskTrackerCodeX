package com.codex.busel.dao;

import com.codex.busel.model.Project;
import com.codex.busel.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by u on 09.04.2015.
 */
@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao{

    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional(readOnly = false)
    public void merge(Project project) {
        if (project.getProjectId() == null) {
            em.persist(project);
        } else {
            em.merge(project);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Project findById(Long id) {
        return em.find(Project.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findTasksByProjectId(Long id) {
        return em.find(Project.class, id).getTasks();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        Query query = em.createQuery("SELECT p FROM Project p");
        List<Project> projects = query.getResultList();
        return projects;
    }
}
