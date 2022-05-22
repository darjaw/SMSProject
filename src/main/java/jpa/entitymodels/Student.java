package jpa.entitymodels;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name="Student.getAllStudents",
                query="from Student"),
        @NamedQuery(name="Student.getStudentByEmail",
                query="Select c from Student c where c.sEmail = :sEmail"),
        @NamedQuery(name="Student.validateStudent",query = "select s from Student s where s.sEmail = :sEmail and s.sPass = :sPassword")
})
public class Student implements Serializable {

    //table columns
    @Column(name = "email", length = 50, nullable = false)
    @Id
    private String sEmail;
    @Column(name = "name",length = 50, nullable = false)
    private String sName;
    @Column(name = "password",length = 50, nullable = false)
    private String sPass;
    @ManyToMany(targetEntity = Course.class, cascade = {CascadeType.ALL})
    private List<Course> sCourses = new ArrayList<>();

    //constructors
    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }
    public Student(){}

    //getters and setters
    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }
}

