package com.amrit.healthcaremanagement.repo;

import com.amrit.healthcaremanagement.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ReportRepo extends JpaRepository<Report, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from medical_data where id=?1"
    )
    Report getById(Integer id);

}
