package com.codex.busel.web.service;

import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;

import java.util.List;

public interface ProjectService {

    Project merge(Project project);

    List<Task> findTasksByProjectId(Long id);

    List<Project>  findAll();

    Project create(Project t);

    void delete(Object id);

    Project find(Object id);

    Project update(Project t);
}
