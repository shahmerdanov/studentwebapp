package com.freedom.studentwebapp.service;
import com.freedom.studentwebapp.entity.student.StudentEntity;
import com.freedom.studentwebapp.mapper.StudentMapper;
import com.freedom.studentwebapp.repository.StudentRepository;
import com.freedom.studentwebapp.service.dto.StudentDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDto add(StudentDto studentDto){
        StudentEntity student = StudentMapper.INSTANCE.toStudentEntity(studentDto);


        repository.save(student);

        studentDto.setId(student.getId());

        return studentDto;


    }
    public StudentEntity findById(Integer id) {
        return repository.getOne(id);
    }


    public List<StudentEntity> getList(String name, String surname,BigDecimal scholarship){

        Specification<StudentEntity> specification = new Specification<StudentEntity>() {
            @Override
            public Predicate toPredicate(Root<StudentEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (name != null && name.trim().length() > 0) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                if (surname != null && surname.trim().length() > 0) {
                    predicates.add(cb.like(root.get("surname").as(String.class), "%" + surname + "%"));
                }
                if (scholarship != null) {
                    predicates.add(cb.equal(root.get("scholarship").as(BigDecimal.class), scholarship));
                }

                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
        return repository.findAll(specification);

    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public StudentEntity update(StudentEntity studentEntity) {
        return repository.save(studentEntity);
    }


}