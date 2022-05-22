package jpa.service;


import jakarta.persistence.*;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import java.util.List;

public class CourseService implements CourseDAO {
    EntityManager entityManager;
    @Override
    public List<Course> getAllCourses() {
        return entityManager.createNamedQuery("Course.getAllCourses", Course.class).getResultList();
    }
}
