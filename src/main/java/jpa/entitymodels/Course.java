package jpa.entitymodels;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "course")
@NamedQuery(name = "Course.getAllCourses", query = "FROM Course c")
public class Course implements Serializable {
    //table columns
    @Column(name = "id", nullable = false)
    @Id
    private Integer cId;
    @Column(name = "name",length = 50, nullable = false)
    private String cName;
    @Column(name = "instructor",length = 50, nullable = false)
    private String cInstructorName;

    public Course(Integer cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public Course() {
    }

    //getters and setters
    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}
