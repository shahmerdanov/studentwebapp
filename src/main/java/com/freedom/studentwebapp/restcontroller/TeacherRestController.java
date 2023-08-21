package com.freedom.studentwebapp.restcontroller;
import com.freedom.studentwebapp.entity.TeacherEntity;
import com.freedom.studentwebapp.mapper.TeacherMapper;
import com.freedom.studentwebapp.restcontroller.dto.request.TeacherUpdateRequestDTO;
import com.freedom.studentwebapp.restcontroller.dto.response.ResponseDto;
import com.freedom.studentwebapp.restcontroller.dto.request.TeacherInsertRequestDTO;
import com.freedom.studentwebapp.restcontroller.dto.response.TeacherInsertResponseDTO;
import com.freedom.studentwebapp.restcontroller.dto.response.TeacherResponseDTO;
import com.freedom.studentwebapp.service.TeacherService;
import com.freedom.studentwebapp.service.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "teachers")
public class TeacherRestController {

    @Autowired
    private TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping

    public ResponseDto<List<TeacherResponseDTO>> getListA(@RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String surname,
                                                          @RequestParam(required = false) BigDecimal salary) {
        List<TeacherEntity> list = teacherService.getList(name, surname, salary);

        List<TeacherResponseDTO> data = new ArrayList<>();
        for (TeacherEntity teacher : list) {
            data.add(TeacherMapper.INSTANCE.toTeacherResponseDTO(teacher));
        }
        ResponseDto<List<TeacherResponseDTO>> responseDTO = new ResponseDto<>();
        responseDTO.setData(data);
        return responseDTO;
    }

    @GetMapping("/{id}")
    public ResponseDto<TeacherResponseDTO> getItem(@PathVariable(required = false, name = "id") Integer id) {
        TeacherEntity teacherEntity = teacherService.findById(id);
        return ResponseDto.ok(TeacherMapper.INSTANCE.toTeacherResponseDTO(teacherEntity));
    }

    @PostMapping
    public ResponseDto<TeacherInsertResponseDTO> add(@RequestBody TeacherInsertRequestDTO teacherRequestDTO) {
        TeacherDTO teacherDTO = TeacherMapper.INSTANCE.toTeacherDTO(teacherRequestDTO);

        TeacherDTO addResult = teacherService.add(teacherDTO);

        TeacherInsertResponseDTO teacherInsertResponseDTO = new TeacherInsertResponseDTO();
        teacherInsertResponseDTO.setId(addResult.getId());

        return ResponseDto.ok(teacherInsertResponseDTO);
    }

    @PutMapping
    public ResponseDto<Boolean> update(@RequestBody TeacherUpdateRequestDTO teacher) {
        TeacherEntity teacherEntity = TeacherMapper.INSTANCE.toTeacherEntity(teacher);
        Boolean result = teacherService.update(teacherEntity) != null;

        return ResponseDto.ok(result);
    }

    @DeleteMapping
    public ResponseDto<Boolean> delete(@RequestParam Integer id) {
        teacherService.deleteById(id);

        return ResponseDto.ok(true);
    }
}
