package com.codex.busel.web.service.impl;

import com.codex.busel.web.dao.ProjectDao;
import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;
import com.codex.busel.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;


    @Override
    @Transactional
    public Project merge(Project project) {
        if (project.getProjectId() == null) {
            project = projectDao.create(project);
            //em.persist(project);
        } else {
            project = projectDao.update(project);
        }
        return project;
    }

    @Override
    @Transactional
    public List<Task> findTasksByProjectId(Long id) {
        return projectDao.findTasksByProjectId(id);
    }

    @Override
    @Transactional
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    @Transactional
    public Project create(Project t) {
        return projectDao.create(t);
    }

    @Override
    @Transactional
    public void delete(Object id) {

    }

    @Override
    @Transactional
    public Project find(Object id) {
        return projectDao.find(id);
    }

    @Override
    @Transactional
    public Project update(Project t) {
        return projectDao.update(t);
    }
}
