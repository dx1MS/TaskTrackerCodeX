package com.codex.busel.controller;

import com.codex.busel.dao.ProjectDao;
import com.codex.busel.dao.TaskDao;
import com.codex.busel.model.Project;
import com.codex.busel.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")

public class HelloController {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private TaskDao taskDao;

	@RequestMapping(value = "project", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
//		em.flush();

		Project projectFetched = projectDao.findById(1L);

		model.addAttribute("tasks", projectDao.findTasksByProjectId(projectFetched.getProjectId()));
//		model.addAttribute("tasks", project.getTasks());

		return "project";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String task(@PathVariable("id") Long id, ModelMap model) {


		Task task1 = taskDao.findById(id);

		model.addAttribute("task", task1);

		return "task";
	}

	@PostConstruct
	public void init() {
		Project project = new Project();
		project.setProjectName("test");

		projectDao.merge(project);

		Task task1 = new Task();
		task1.setDescr("descr1");
		project.addTask(task1);
		taskDao.merge(task1);

		Task task2 = new Task();
		task2.setDescr("descr2");
		project.addTask(task2);
		taskDao.merge(task2);

		projectDao.merge(project);
	}
}