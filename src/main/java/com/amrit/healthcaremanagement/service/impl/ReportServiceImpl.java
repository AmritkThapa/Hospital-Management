package com.amrit.healthcaremanagement.service.impl;

import com.amrit.healthcaremanagement.entity.Report;
import com.amrit.healthcaremanagement.repo.ReportRepo;
import com.amrit.healthcaremanagement.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepo reportRepo;
    @Override
    public List<Report> getAllReport() {
        return reportRepo.findAll();
    }
    @Override
    public void addReport(Report report) {
        reportRepo.save(report);
    }

    //Update report
    @Override
    public Optional<Report> getReportById(Integer id) {
        return reportRepo.findById(id);
    }

    //Delete Report
    @Override
    public void deleteReportById(Integer id) {
        reportRepo.deleteById(id);
    }
}
