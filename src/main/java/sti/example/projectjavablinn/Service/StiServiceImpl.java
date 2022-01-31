package sti.example.projectjavablinn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sti.example.projectjavablinn.Entity.Student;
import sti.example.projectjavablinn.Repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StiServiceImpl implements StiService{

    @Autowired
    private StudentRepository studentRepository;

    public StiServiceImpl(StudentRepository repository){
        this.studentRepository = repository;
    }

    public List<Student> findAll() {

        List<Student> allStudents = new ArrayList<>();

        Iterable<Student> studentList = studentRepository.findAll();

        studentList.forEach(allStudents::add);

        return allStudents;
    }

    public ResponseEntity<Object> addStudent(Student student){
        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body("New Student created successfully");
    }

    public Student findByNumber(Long number){
        Optional<Student> studentOpt = studentRepository.findByNumber(number);

        if(studentOpt.isPresent())
            return  studentOpt.get();

        throw new RuntimeException("Not found for the id " + number);
    }

    public ResponseEntity<Object> deleteStudent(Long number){
        Optional<Student> studentOpt = studentRepository.findByNumber(number);

        if(studentOpt.isPresent()){
            Student managedStudentOpt = studentOpt.get();
            studentRepository.delete(managedStudentOpt);
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student doesn't exist.");
        }
    }
}
