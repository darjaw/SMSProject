package jpa.service;


import jakarta.persistence.EntityManager;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseService implements CourseDAO {

    @Override
    public List<Course> getAllCourses() {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        EntityManager entityManager = factory.createEntityManager();
        List<Course> courses;
        courses = entityManager.createNamedQuery
                ("Course.getAllCourses", Course.class)
                .getResultList();

        for (Course o : courses) {
            System.out.println("Course instructor : " + o.getcInstructorName() + " | course name: " + o.getcName());
        }

        factory.close();
        session.close();
        return courses;
    }

    public Course GetCourseById(int courseId) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        return session.get(Course.class, courseId);
    }
}
