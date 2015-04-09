package com.codex.busel.controller;

import com.codex.busel.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@PersistenceContext
	EntityManager em;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");

		Project project = new Project();
		project.setProjectName("test");
		em.persist(project);
		em.merge(project);

//		em.flush();

		Project project2 = em.find(Project.class, 0L);
		Project project3 = em.find(Project.class, 1L);

		Query query = em.createQuery("SELECT p FROM Project p");
		List<Project> projects = query.getResultList();

		return "hello";
	}
}