package sti.example.projectjavablinn.Service;

import org.springframework.http.ResponseEntity;
import sti.example.projectjavablinn.Entity.Student;

import java.util.List;

public interface StiService {

    public List<Student> findAll();

    public ResponseEntity<Object> addStudent(Student student);

    public Student findByNumber(Long number);

    public ResponseEntity<Object> deleteStudent(Long number) ;

}
