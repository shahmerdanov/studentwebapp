package com.freedom.studentwebapp.mapper;
import com.freedom.studentwebapp.entity.TeacherEntity;
import com.freedom.studentwebapp.restcontroller.dto.request.TeacherInsertRequestDTO;
import com.freedom.studentwebapp.restcontroller.dto.request.TeacherUpdateRequestDTO;
import com.freedom.studentwebapp.restcontroller.dto.response.TeacherResponseDTO;
import com.freedom.studentwebapp.service.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper( TeacherMapper.class );
    TeacherDTO toTeacherDTO(TeacherInsertRequestDTO requestDTO);//??Bu body-siz methoddur ve Mapper impl-siya yaradir
    @Mapping(source = "universityId.id", target = "universityId")
    TeacherDTO toTeacherDTO(TeacherEntity teacherEntity);
    @Mapping(source = "universityId", target = "universityId.id")
    TeacherEntity toTeacherEntity(TeacherDTO dto);
    @Mapping(source = "universityId", target = "universityId.id")
    TeacherEntity toTeacherEntity(TeacherUpdateRequestDTO dto);


    @Mapping(source = "universityId.id", target = "universityId")
    TeacherResponseDTO toTeacherResponseDTO(TeacherEntity teacherEntiy);
}
