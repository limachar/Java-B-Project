package sti.example.projectjavablinn.Service;

import org.springframework.http.ResponseEntity;
import sti.example.projectjavablinn.Entity.Course;
import sti.example.projectjavablinn.Entity.Student;
import sti.example.projectjavablinn.Entity.Teacher;

import java.util.List;

public interface StiService {

    List<Student> findAllStudents();

    ResponseEntity<Object> addStudent(Student student);

    Student findByNumber(Long number);

    ResponseEntity<Object> deleteStudent(Long number);



    List<Teacher> findAllTeachers();

    ResponseEntity<Object> addTeacher(Teacher teacher);

    Teacher findByNum(Long number);

    ResponseEntity<Object> deleteTeacher(Long number);



    ResponseEntity<Object> addCourse(Course course);

    ResponseEntity<Object> addCourseToStudent(Long number1, Long number2);
    ResponseEntity<Object> addCourseToTeacher(Long number1, Long number2);
}
