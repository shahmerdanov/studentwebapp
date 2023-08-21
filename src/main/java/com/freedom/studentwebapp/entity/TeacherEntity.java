package com.freedom.studentwebapp.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "teacher")
@NamedQueries({
    @NamedQuery(name = "findById", query = "SELECT m FROM TeacherEntity m")})
public class TeacherEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "salary")
    private BigDecimal salary;

    @JoinColumn(name = "university", referencedColumnName = "id")
    @ManyToOne
    private UniversityEntity universityId;
    @Column(name = "created_on")
  //  @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
  //  @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;


    public TeacherEntity() {
    }

    public TeacherEntity(Integer id) {
        this.id = id;
    }

    public TeacherEntity(Integer id, String name, String surname, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public TeacherEntity setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherEntity setName(final String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public TeacherEntity setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public TeacherEntity setSalary(final BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public TeacherEntity setCreatedOn(final Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public TeacherEntity setUpdatedOn(final Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public UniversityEntity getUniversityId() {
        return universityId;
    }

    public TeacherEntity setUniversityId(final UniversityEntity universityId) {
        this.universityId = universityId;
        return this;
    }


}
