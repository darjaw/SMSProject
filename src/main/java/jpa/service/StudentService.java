package jpa.service;

import jakarta.persistence.EntityManager;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentService implements StudentDAO {

    @Override
    public List<Student> getAllStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        EntityManager entityManager = factory.createEntityManager();
        session.close();
        entityManager.close();
        return entityManager.createNamedQuery("Student.getAllStudents", Student.class).getResultList();

    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        EntityManager entityManager = factory.createEntityManager();
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
            System.out.println("Incorrect email or password");
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String studentEmail, int courseId) {
        boolean temp = false;

        // open session factory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // Create student object using session.get()
        Student student = session.get(Student.class, studentEmail);

        // create course list
        List<Course> courseList = student.getsCourses();

        if (courseList.isEmpty()) {

            Course course = session.get(Course.class, courseId);

            courseList.add(course);

            student.setsCourses(courseList);

            session.merge(student);
            session.getTransaction().commit();
        }

        if (courseList.size() >= 1) {

            for (Course u : courseList) {
                int id = u.getcId();
                //if course is already in the list, do nothing
                if (id == courseId) {
                    System.out.println("Course already registered");
                    temp = true;
                }
            }

            if (!temp) {

                // create the course object
                Course course = session.get(Course.class, courseId);

                // insert the course object
                courseList.add(course);

                // set attribute
                student.setsCourses(courseList);

                session.merge(student);
                session.getTransaction().commit();
            }

        }

        factory.close();
        session.close();

    }

    @Override
    public List<Course> getStudentCourses(String studentEmail) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student = (Student) session.get(Student.class, new String(studentEmail));
        List<Course> studentClassList = student.getsCourses();

        factory.close();
        session.close();

        return studentClassList;
    }
    }

