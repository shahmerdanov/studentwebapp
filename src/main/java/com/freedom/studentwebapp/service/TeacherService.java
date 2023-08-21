package com.freedom.studentwebapp.service;
import com.freedom.studentwebapp.entity.TeacherEntity;
import com.freedom.studentwebapp.mapper.TeacherMapper;
import com.freedom.studentwebapp.repository.TeacherRepository;
import com.freedom.studentwebapp.service.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class TeacherService{

    @Autowired
    private TeacherRepository repository;

    public TeacherDTO add(TeacherDTO teacherDTO) {

        TeacherEntity teacherEntity = TeacherMapper.INSTANCE.toTeacherEntity(teacherDTO);
        repository.save(teacherEntity);
        teacherDTO.setId(teacherEntity.getId());

        return teacherDTO;
    }

    public TeacherEntity update(TeacherEntity teacherEntity) {
        return repository.save(teacherEntity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public TeacherEntity findById(Integer id) {
        return repository.getReferenceById(id);
    }

    public List<TeacherEntity> getList(String name, String surname, BigDecimal salary) {
        Specification<TeacherEntity> specification = new Specification<TeacherEntity>() {

            @Override
            public Predicate toPredicate(Root<TeacherEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (name != null && name.trim().length() > 0) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                if (surname != null && surname.trim().length() > 0) {
                    predicates.add(cb.like(root.get("surname").as(String.class), "%" + surname + "%"));
                }
                if (salary != null) {
                    predicates.add(cb.equal(root.get("salary").as(BigDecimal.class), salary));
                }
                final Predicate all = cb.and(predicates.toArray(new Predicate[]{}));
                return all;
            }
        };
        return repository.findAll(specification);

    }


}

