package com.amrit.healthcaremanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private Integer id;
    private String name;
    private Integer age;
    private MultipartFile image;

}
