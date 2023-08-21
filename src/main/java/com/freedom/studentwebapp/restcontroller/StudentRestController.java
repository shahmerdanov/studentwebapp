package com.freedom.studentwebapp.restcontroller;
import com.freedom.studentwebapp.entity.student.StudentEntity;
import com.freedom.studentwebapp.mapper.StudentMapper;
import com.freedom.studentwebapp.restcontroller.dto.request.StudentInsertRequestDto;
import com.freedom.studentwebapp.restcontroller.dto.request.StudentUpdateRequestDto;
import com.freedom.studentwebapp.restcontroller.dto.response.ResponseDto;
import com.freedom.studentwebapp.restcontroller.dto.response.StudentInsertResponseDto;
import com.freedom.studentwebapp.restcontroller.dto.response.StudentResponseDto;
import com.freedom.studentwebapp.service.StudentService;
import com.freedom.studentwebapp.service.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "students")
public class StudentRestController {


    private StudentService studentService;



    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping
    public ResponseDto<List<StudentResponseDto>> getList(@RequestParam(required = false, value = "name") String name,
                                                         @RequestParam(required = false,value = "surname") String surname,
                                                         @RequestParam(required = false,value = "salary") BigDecimal salary ){
        List<StudentEntity> studentEntityList = studentService.getList(name, surname, salary);

        List<StudentResponseDto> data = new ArrayList<>();
        for(StudentEntity studentEntity: studentEntityList){
            data.add(StudentMapper.INSTANCE.toStudentResponseDto(studentEntity));

        }


        ResponseDto<List<StudentResponseDto>> responseDto  =  new ResponseDto<>();
        responseDto.setData(data);

        return responseDto;


    }

    @GetMapping("/{id}")
    public ResponseDto<StudentResponseDto> getList(@PathVariable(required = false, name = "id") Integer id){
        StudentEntity studentEntity = studentService.findById(id);

        return ResponseDto.ok(StudentMapper.INSTANCE.toStudentResponseDto(studentEntity));


    }


    @PostMapping
    public ResponseDto<StudentInsertResponseDto> add(@RequestBody StudentInsertRequestDto studentRequestDto){
        StudentDto studentDto = StudentMapper.INSTANCE.toStudentDto(studentRequestDto);


        final StudentDto addResult = studentService.add(studentDto);


        StudentInsertResponseDto studentInsertResponseDto =  new StudentInsertResponseDto();
        studentInsertResponseDto.setId(addResult.getId());
        final ResponseDto<StudentInsertResponseDto> responseDto = new ResponseDto<>();


        return ResponseDto.ok(studentInsertResponseDto);
    }

    @PutMapping
    public ResponseDto<Boolean> update(@RequestBody StudentUpdateRequestDto studentUpdateRequestDto){
        StudentEntity studentEntity = StudentMapper.INSTANCE.toStudentEntity(studentUpdateRequestDto);

        return  ResponseDto.ok(studentService.update(studentEntity)!=null);
    }

    @DeleteMapping
    public ResponseDto<Boolean> delete(@RequestParam Integer id){
        studentService.deleteById(id);

        return ResponseDto.ok(true);
    }




}