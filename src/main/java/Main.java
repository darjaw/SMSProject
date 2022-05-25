import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = studentService.getStudentByEmail("htaffley6@columbia.edu");
        System.out.println(student.getsName());    }
}
