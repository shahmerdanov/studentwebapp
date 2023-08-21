package com.freedom.studentwebapp.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherDTO {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;

}
