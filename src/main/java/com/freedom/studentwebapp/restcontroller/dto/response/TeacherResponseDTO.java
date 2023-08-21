package com.freedom.studentwebapp.restcontroller.dto.response;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TeacherResponseDTO {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;

}
