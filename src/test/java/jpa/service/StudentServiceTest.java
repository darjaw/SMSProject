package jpa.service;

import jpa.entitymodels.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StudentServiceTest {

    @Test
    void getStudentByEmail() {
        StudentService studentService = new StudentService();
        Student testStudent = studentService.getStudentByEmail("ljiroudek8@sitemeter.com");
        Student foundStudent = new Student("ljiroudek8@sitemeter.com","Laryssa Jiroudek","bXRoLUP", new ArrayList<>());
        Assertions.assertEquals(foundStudent, testStudent);
    }


}