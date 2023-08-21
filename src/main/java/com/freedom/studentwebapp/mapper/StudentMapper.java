package com.freedom.studentwebapp.mapper;
import com.freedom.studentwebapp.entity.student.StudentEntity;
import com.freedom.studentwebapp.restcontroller.dto.request.StudentInsertRequestDto;
import com.freedom.studentwebapp.restcontroller.dto.request.StudentUpdateRequestDto;
import com.freedom.studentwebapp.restcontroller.dto.response.StudentResponseDto;
import com.freedom.studentwebapp.service.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toStudentDto(StudentInsertRequestDto requestDto);
    @Mapping(source = "universityId.id", target = "universityId")
    StudentDto toStudentDto(StudentEntity studentEntity);

    @Mapping(source = "universityId", target = "universityId.id")
    StudentEntity toStudentEntity(StudentDto dto);

    @Mapping(source = "universityId", target = "universityId.id")
    StudentEntity toStudentEntity(StudentUpdateRequestDto dto);


    @Mapping(source = "universityId.id", target = "universityId")
    StudentResponseDto toStudentResponseDto(StudentEntity studentEntity);
}
