package com.codex.busel.web.controller;

import com.codex.busel.web.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("developer")
public class DeveloperController {

    @Autowired
    private TaskService taskService;

//    @RequestMapping("/")
//    public String start() {
//        return "tasks";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printFirstDev (ModelMap model) {
        model.addAttribute("message", "Your tasks:");

        model.addAttribute("tasks", taskService.findAll());
        return "tasks";
    }
}
