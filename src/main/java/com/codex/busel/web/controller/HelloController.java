package com.codex.busel.web.controller;

import com.codex.busel.web.dao.ProjectDao;
import com.codex.busel.web.dao.TaskDao;
import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;
import com.codex.busel.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

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
		User user = new User();


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