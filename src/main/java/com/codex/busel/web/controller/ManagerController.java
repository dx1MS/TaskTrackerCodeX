package com.codex.busel.web.controller;

import com.codex.busel.web.dao.UserDao;
import com.codex.busel.web.model.*;
import com.codex.busel.web.service.ProjectService;
import com.codex.busel.web.service.TaskService;
import com.codex.busel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("manager1")
public class ManagerController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TaskService taskService;

//    @RequestMapping("/")
//    public String start() {
//        return "projects";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
//		em.flush();
//		Project projectFetched = projectDao.findById(1L);
//		model.addAttribute("tasks", projectDao.findTasksByProjectId(projectFetched.getProjectId()));
//		model.addAttribute("tasks", projectDao.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "projects";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject(ModelMap model, @ModelAttribute("project") Project project) {
        project.setProjectName("Enter your project name");
        project = projectService.merge(project);
        addDeveloperMap(model);
        model.addAttribute("projectId", project.getProjectId());
        model.addAttribute("message", "project details(tasks)");
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
                taskService.merge(task);
            }
        }
        projectService.merge(project);

        addDeveloperMap(model);
        model.addAttribute("projectId", project.getProjectId());

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

            if (task.getUser() != null) {
                User user = userDao.find(task.getUser());
                task.setUser(user);
            }

            //taskDao.merge(task);

            Project project = projectService.find(projectId);
            project.addTask(task);
            taskService.merge(task);
            projectService.update(project);

        }

        Project project = projectService.find(projectId);
        model.addAttribute("project", project);

        return "projectDetails";
    }

//	@PostConstruct
//	public void init() {
//        // man1, dev1
//        User user1 = new User();
//        User user2 = new User();
//        user1.setUserName("man1");
//        user2.setUserName("dev1");
//        user1.setPassword("1");
//        user2.setPassword("1");
//        user1.setEnabled(1);
//        user2.setEnabled(1);
//        userService.merge(user1);
//        userService.merge(user2);
//
//        //ROLE
//        UserRole roleMan = new UserRole();
//        UserRole roleDev = new UserRole();
//        roleDev.setNameRole(NameRole.DEVELOPER);
//        roleMan.setNameRole(NameRole.MANAGER);
//
//        //merge Role?
//
//        user1.addUserRoles(roleMan);
//        user2.addUserRoles(roleDev);
//        userService.merge(user1);
//        userService.merge(user2);
//
//        // Project1, Project2Q
//		Project project1 = new Project();
//        Project project2 = new Project();
//		project1.setProjectName("Project1");
//        project2.setProjectName("Project2");
//        projectService.merge(project1);
//        projectService.merge(project2);
//
//        // Task11_descr - Project1, null(user)
//        //         Task12_descr - Project1, null
//        //         Task21_descr - Project2, null
//		Task task11 = new Task();
//        Task task12 = new Task();
//		task11.setDescr("Task11_descr");
//        task12.setDescr("Task12_descr");
//        //
//        project1.addTask(task11);
//        project1.addTask(task12);
//        taskService.merge(task11);
//        taskService.merge(task12);
//
//		Task task21 = new Task();
//		task21.setDescr("Task21_descr");
//		project2.addTask(task21);
//        taskService.merge(task21);
//
//        projectService.merge(project1);
//        projectService.merge(project2);
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