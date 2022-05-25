package jpa.entitymodels;

import java.io.Serializable;

import jakarta.persistence.*;
@Entity
@Table(name = "student_course")
@NamedQueries({ @NamedQuery(name = "Select_All_Registered_Courses", query = "from RegisteredCourse"),
        @NamedQuery(name = "Select_Registered_Courses_by_Student", query = "Select c from RegisteredCourse c where c.sEmail = :email"), })
public class RegisteredCourse implements Serializable {


    // column variables
    @Id
    @Column(name = "student_email", nullable = false)
    private String sEmail;
    @Id
    @Column(name = "course_id", nullable = false)
    private int courseId;

    // constructors
    public RegisteredCourse(String sEmail, Integer courseId) {
        this.sEmail = sEmail;
        this.courseId= courseId;
    }

    public RegisteredCourse() {
    }

   //getters and setters


    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + courseId;
        result = prime * result + ((sEmail == null) ? 0 : sEmail.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegisteredCourse other = (RegisteredCourse) obj;

        if (courseId!= other.courseId)
            return false;
        if (sEmail == null) {
            return other.sEmail == null;
        } else return sEmail.equals(other.sEmail);
    }

}
