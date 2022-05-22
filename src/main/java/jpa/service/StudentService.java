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
        //TODO: implement this method
        return false;
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {

    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        return null;
    }
}
