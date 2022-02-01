package sti.example.projectjavablinn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sti.example.projectjavablinn.Entity.Student;
import sti.example.projectjavablinn.Service.StiServiceImpl;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StiServiceImpl stiService;

    @PostMapping("/students")
    public ResponseEntity<Object> addStudent (@RequestBody Student student) {

        return stiService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents () {

        return stiService.findAllStudents();
    }

    @GetMapping("/students/{number}")
    public Student getStudent (@PathVariable Long number) {

        return stiService.findByNumber(number);
    }

    /*@PutMapping("/students/{id}")
    public Student update (@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepo.save(student);
    }*/

    @DeleteMapping("/students/{number}")
    public ResponseEntity<Object> deleteStudent (@PathVariable Long number) {

        return stiService.deleteStudent(number);
    }
}
