package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

public interface StudentCourseDAO {

    List<Course> getAllStudentCourses(String studentEmail);

}
