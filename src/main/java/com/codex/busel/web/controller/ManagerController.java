package com.codex.busel.web.controller;

import com.codex.busel.web.dao.TaskDao;
import com.codex.busel.web.dao.UserDao;
import com.codex.busel.web.model.Project;
import com.codex.busel.web.model.Task;
import com.codex.busel.web.model.User;
import com.codex.busel.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ManagerController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String start() {
        return "projects";
    }

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
//		em.flush();

//		Project projectFetched = projectDao.findById(1L);

//		model.addAttribute("tasks", projectDao.findTasksByProjectId(projectFetched.getProjectId()));
//		model.addAttribute("tasks", projectDao.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "projects";
    }

    @RequestMapping(value = "addProject", method = RequestMethod.GET)
    public String addProject(ModelMap model, @ModelAttribute("project") Project project) {
        project.setProjectName("Enter your project name");
        project = projectService.merge(project);
        addDeveloperMap(model);
        model.addAttribute("projectId", project.getProjectId());
        return "projectDetails";
    }

    @RequestMapping(value = "editProject", method = RequestMethod.GET)
    public String showProject(ModelMap model, @RequestParam("projectId") Long projectId) {

        Project project = projectService.find(projectId);
        model.addAttribute("project", project);
        addDeveloperMap(model);
        model.addAttribute("projectId", project.getProjectId());

        return "projectDetails";
    }

    private void addDeveloperMap(ModelMap model) {
//		Map<Long, String> developerMap = new HashMap<Long, String>();
        List<User> developers = userDao.findDevelopers();
//		for (User developer : developers) {
        model.addAttribute("developersList", developers);
//			developerMap.put(developer.getUserId(), developer.getUserName());
//		}
//
//		model.addAttribute("developerMap", developerMap);
    }

    @RequestMapping(value = "saveProject")
    public String saveProject(ModelMap model, @ModelAttribute("project") Project project) {
        if (project.getTasks() != null) {
            for (Task task : project.getTasks()) {
                taskDao.merge(task);
            }
        }
        projectService.merge(project);

        addDeveloperMap(model);

        return "projectDetails";
    }

//	@RequestMapping(value = "{id}", method = RequestMethod.GET)
//	public String task(@PathVariable("id") Long id, ModelMap model) {
//
//		Task task1 = taskDao.find(id);
//
//		model.addAttribute("task", task1);
//
//		return "task";
//	}

    @RequestMapping(value = "new_task")
    public String task(@ModelAttribute("task") Task task, ModelMap model, @RequestParam("projectId") Long projectId) {

        model.addAttribute("projectId", projectId);
        addDeveloperMap(model);

        return "task";
    }

    @RequestMapping(value = "save_task")
    public String saveTask(@ModelAttribute("task") Task task, ModelMap model, @RequestParam("projectId") Long projectId) {
        if (task != null && task.getDescr() != null) {

            if (task.getUserId() != null) {
                User user = userDao.find(task.getUserId());
                task.setUser(user);
            }

            taskDao.merge(task);

            Project project = projectService.find(projectId);
            project.addTask(task);
            projectService.update(project);

        }

        Project project = projectService.find(projectId);
        model.addAttribute("project", project);

        return "projectDetails";
    }

//	@PostConstruct
//	public void init() {
//
//		Project project = new Project();
//		project.setProjectName("test");
//
//		projectDao.merge(project);
//
//		Task task1 = new Task();
//		task1.setDescr("descr1");
//		project.addTask(task1);
//		taskDao.merge(task1);
//
//		Task task2 = new Task();
//		task2.setDescr("descr2");
//		project.addTask(task2);
//		taskDao.merge(task2);
//
//		projectDao.merge(project);
//	}

    @ModelAttribute("project")
    public Project populateProject() {
        Project project = new Project();
        return project;
    }

    @ModelAttribute("task")
    public Task populateTask() {
        Task task = new Task();
        return task;
    }
}