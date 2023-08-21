package com.freedom.studentwebapp.restcontroller.dto.request;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class StudentUpdateRequestDto {

    private Integer id;
    private String name;
    private String surname;
    private BigDecimal scholarship;
    private Integer universityId;
}
