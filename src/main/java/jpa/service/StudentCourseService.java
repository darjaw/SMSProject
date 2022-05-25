package jpa.service;

import java.util.List;

import jpa.dao.StudentCourseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentCourseService implements StudentCourseDAO {

    public List<Course> getAllStudentCourses(String studentEmail) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();


        Student student = session.get(Student.class, studentEmail);

        List<Course> coursesBeingTaken = student.getsCourses();

        factory.close();
        session.close();

        return coursesBeingTaken;
    }

}
