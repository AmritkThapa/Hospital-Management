package com.amrit.healthcaremanagement.controller;

import com.amrit.healthcaremanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ReportService reportService;

    @GetMapping("/")
    public String loadIndexPage(Model model){
        model.addAttribute("report", reportService.getAllReport());
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
