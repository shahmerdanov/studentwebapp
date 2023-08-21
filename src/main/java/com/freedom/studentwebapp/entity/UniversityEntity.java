package com.freedom.studentwebapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freedom.studentwebapp.entity.student.StudentEntity;
import com.freedom.studentwebapp.entity.student.StudentUniversityEntity;
import lombok.Data;


@Entity
@Data
@Table(name = "university")
public class UniversityEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy = "universityId", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TeacherEntity> teacherList;

    @JsonIgnore
    @OneToMany(mappedBy = "universityId", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<StudentEntity> studentList;
    @JsonIgnore
    @OneToMany(mappedBy = "universityId" , orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TeacherUniversityEntity> teacherUniversityList;

    @JsonIgnore
    @OneToMany(mappedBy = "universityId",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<StudentUniversityEntity> studentUniversityList;

    public UniversityEntity() {
    }

    public UniversityEntity(Integer id) {
        this.id = id;
    }

    public UniversityEntity(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TeacherEntity> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherEntity> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniversityEntity)) {
            return false;
        }
        UniversityEntity other = (UniversityEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @XmlTransient
    public List<TeacherUniversityEntity> getTeacherUniversityList() {
        return teacherUniversityList;
    }

    public void setTeacherUniversityList(List<TeacherUniversityEntity> teacherUniversityList) {
        this.teacherUniversityList = teacherUniversityList;
    }
    
}
