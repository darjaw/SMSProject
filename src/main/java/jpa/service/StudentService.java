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
        return null;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
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
