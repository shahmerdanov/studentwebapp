package com.freedom.studentwebapp.restcontroller.dto.request;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TeacherInsertRequestDTO {

    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;

}
