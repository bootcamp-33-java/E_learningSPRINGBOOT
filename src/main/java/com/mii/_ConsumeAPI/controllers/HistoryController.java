/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii._ConsumeAPI.controllers;

import com.mii._ConsumeAPI.services.AnswerQuestionService;
import com.mii._ConsumeAPI.services.EmpActionService;
import com.mii._ConsumeAPI.services.EmpBundleService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author BWP
 */
@Controller
public class HistoryController {
    
    @Autowired
    EmpActionService empActionService;

    @Autowired
    EmpBundleService empBAService;
    
    @Autowired
    AnswerQuestionService ansquestionservice;
    
    
    @RequestMapping("/history_quiz")
    public String historyQuiz(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("quizzz", empBAService.getByEmployee(request.getSession().getAttribute("employeeid").toString()));
        System.out.println("NAMA 44FORUM= " + model.getAttribute("nama"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
//        model.addAttribute("theories", theoryservice.getAll());

        return "history_quiz";
    }
    
    @RequestMapping("/history_action")
    public String historyAction(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("employeeid",request.getSession().getAttribute("employeeid")); 
        System.out.println("NAMA 44FORUM= " + model.getAttribute("nama"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        model.addAttribute("actions", empActionService.getByEmployee(model.getAttribute("employeeid").toString()));
        return "history_action";
    }
    
    @RequestMapping("/history_answer")
    public String historyAnswer(Model model, HttpServletRequest request) {
        model.addAttribute("nama", "Hallo " + request.getSession().getAttribute("employee"));
        model.addAttribute("employeeid",request.getSession().getAttribute("employeeid")); 
        System.out.println("NAMA 44FORUM= " + model.getAttribute("nama"));
        model.addAttribute("rolenya", request.getSession().getAttribute("role"));
        model.addAttribute("answer", ansquestionservice.getAll());
        return "history_answer";
    }
}
