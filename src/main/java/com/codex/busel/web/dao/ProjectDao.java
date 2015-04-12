package com.codex.busel.web.dao;

import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;

import java.util.List;

public interface ProjectDao extends GenericDao<Project> {

    List<Task> findTasksByProjectId(Long id);

    List<Project>  findAll();
}
