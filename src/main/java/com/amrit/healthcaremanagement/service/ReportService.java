package com.amrit.healthcaremanagement.service;

import com.amrit.healthcaremanagement.entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    public List<Report> getAllReport();
    public void addReport(Report report);
    public void deleteReportById(Integer id);
    public Optional<Report> getReportById(Integer id);

}
