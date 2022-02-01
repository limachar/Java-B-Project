package sti.example.projectjavablinn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sti.example.projectjavablinn.Entity.Course;
import sti.example.projectjavablinn.Entity.Teacher;
import sti.example.projectjavablinn.Service.StiServiceImpl;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private StiServiceImpl stiService;

    @PostMapping("/courses")
    public ResponseEntity<Object> addCourse (@RequestBody Course course) {

        return stiService.addCourse(course);
    }
}
