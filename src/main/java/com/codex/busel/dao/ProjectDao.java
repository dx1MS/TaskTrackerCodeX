package com.codex.busel.dao;

import com.codex.busel.model.Project;
import com.codex.busel.model.Task;

import java.util.List;

/**
 * Created by u on 09.04.2015.
 */
public interface ProjectDao {

    void merge(Project project);

    Project findById(Long id);

    List<Task> findTasksByProjectId(Long id);

    List<Project>  findAll();
}
