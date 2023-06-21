package com.amrit.healthcaremanagement.controller;

import com.amrit.healthcaremanagement.dto.ReportDto;
import com.amrit.healthcaremanagement.entity.Report;
import com.amrit.healthcaremanagement.service.ReportService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ReportController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/report-pdf";

    @Autowired
    ReportService reportService;

    //Load Report Page
    @GetMapping("/dashboard/report")
    public String loadReport(Model model) {
        model.addAttribute("report", reportService.getAllReport());
        return "report";
    }

    //Create a new
    @GetMapping("/dashboard/report/add")
    public String addReport(Model model){
        model.addAttribute("reportDto",new Report());
        return "addReport";
    }

    //Submit form data
    @PostMapping("/dashboard/report/add")
    public String addReportPost(@ModelAttribute("reportDto")ReportDto reportDto,
                                @RequestParam("image")MultipartFile file,
                                @RequestParam("imgName")String imgName) throws IOException{
        Report report = new Report();
        report.setId(reportDto.getId());
        report.setName(reportDto.getName());
        report.setAge(reportDto.getAge());

        String imageName;
        if(!file.isEmpty()){
            imageName = file.getOriginalFilename();
            Path fileNameWithPath = Paths.get(uploadDir, imageName);
            Files.write(fileNameWithPath,file.getBytes());
        } else{
            imageName = imgName;
        }
        report.setImage(imageName);
        reportService.addReport(report);
        return "redirect:/dashboard/report";
    }

    //Delete Report
    @GetMapping("/dashboard/report/delete/{id}")
    public String deleteReport(@PathVariable Integer id){
        reportService.deleteReportById(id);
        return "redirect:/dashboard/report";
    }


    @GetMapping("/dashboard/report/update/{id}")
    public String updateReport(@PathVariable Integer id, Model model){
        Report report = reportService.getReportById(id).get();
        ReportDto reportDto = new ReportDto();
        reportDto.setId(report.getId());
        reportDto.setName(report.getName());
        reportDto.setAge(report.getAge());

        model.addAttribute("reportDto", reportDto);
        return "addReport";

    }

    @GetMapping("/dashboard/report/open")
    public String openReport(Model model) {
        model.addAttribute("report", reportService.getAllReport());
        return "report";
    }
}
