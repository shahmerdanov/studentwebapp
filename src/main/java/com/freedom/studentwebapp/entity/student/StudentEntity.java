package com.freedom.studentwebapp.entity.student;
import com.freedom.studentwebapp.entity.UniversityEntity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "student")
@Data
public class StudentEntity implements Serializable {

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
    @Column(name = "scholarship")
    private BigDecimal scholarship;



    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @ManyToOne
    private UniversityEntity universityId;


    @Column(name = "created_on")
  //  @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
  //  @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;


   // @JsonIgnore
    @OneToMany(mappedBy = "studentId")
    private List<StudentUniversityEntity> studentUniversityList;


}