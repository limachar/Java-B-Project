package sti.example.projectjavablinn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sti.example.projectjavablinn.Entity.Teacher;
import sti.example.projectjavablinn.Service.StiServiceImpl;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    @Autowired
    private StiServiceImpl stiService;

    @PostMapping("/teachers")
    public ResponseEntity<Object> addTeacher (@RequestBody Teacher teacher) {

        return stiService.addTeacher(teacher);
    }
    @PutMapping("/students/{number}/{id}")
    public ResponseEntity<Object> addCourseToTeacher (@PathVariable Long number, @PathVariable Long id) {

        return stiService.addCourseToTeacher(number, id);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers () {

        return stiService.findAllTeachers();
    }

    @GetMapping("/teachers/{num}")
    public Teacher getTeacher (@PathVariable Long number) {

        return stiService.findByNum(number);
    }

    /*@PutMapping("/teachers/{id}")
    public Teacher update (@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherRepo.save(teacher);
    }*/

    @DeleteMapping("/teachers/{num}")
    public ResponseEntity<Object> deleteTeacher (@PathVariable Long number) {

        return stiService.deleteTeacher(number);
    }

    @GetMapping("/teachers/monthly/{num}")
    public int getMonthly(@PathVariable Long num){
        Teacher teacherOpt = stiService.findByNum(num);
        return stiService.getMonthly(teacherOpt.getHourlyPay());

    }
}
