package sti.example.projectjavablinn.Service;

import org.springframework.http.ResponseEntity;
import sti.example.projectjavablinn.Entity.Student;

import java.util.List;

public interface StiService {

    public List<Student> findAll();

    public ResponseEntity<Object> addStudent(Student student);

    public Student findByStudentId(Long id);

    public ResponseEntity<Object> deleteStudent(Long id) ;

}
