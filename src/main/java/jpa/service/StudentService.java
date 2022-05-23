package jpa.service;

import jakarta.persistence.EntityManager;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public class StudentService implements StudentDAO {
    EntityManager entityManager;
    @Override
    public List<Student> getAllStudents() {
        return entityManager.createNamedQuery("Student.getAllStudents", Student.class).getResultList();
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        return entityManager.createNamedQuery("Student.getStudentByEmail", Student.class)
                .setParameter("sEmail", sEmail).getSingleResult();
    }

    @Override
    public boolean validateStudent(String sEmail, String sPass) {
        try {
            //use sEmail to make a Student object
            Student unverifiedStudent = getStudentByEmail(sEmail);
            //if student is found returns true, else false
            return unverifiedStudent.getsEmail().equals(sEmail) && unverifiedStudent.getsPass().equals(sPass);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        //TODO: implement this method
        //if student is not registered to course, register student to course

        //if student is registered to course, do not register student to course print error message
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        //TODO: implement this method
        return null;
    }
}
