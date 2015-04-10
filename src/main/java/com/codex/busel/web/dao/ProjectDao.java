package com.codex.busel.web.dao;

import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;

import java.util.List;

public interface ProjectDao {

    void merge(Project project);

    Project findById(Long id);

    List<Task> findTasksByProjectId(Long id);

    List<Project>  findAll();
}
