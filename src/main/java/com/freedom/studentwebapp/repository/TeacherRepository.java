package com.freedom.studentwebapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.freedom.studentwebapp.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer>, JpaSpecificationExecutor<TeacherEntity> {

}