package sti.example.projectjavablinn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sti.example.projectjavablinn.Entity.Course;
import sti.example.projectjavablinn.Entity.Student;
import sti.example.projectjavablinn.Entity.Teacher;
import sti.example.projectjavablinn.Repository.CourseRepository;
import sti.example.projectjavablinn.Repository.StudentRepository;
import sti.example.projectjavablinn.Repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StiServiceImpl implements StiService{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    public StiServiceImpl(StudentRepository studentrepository, TeacherRepository teacherrepository){
        this.studentRepository = studentrepository;
        this.teacherRepository = teacherrepository;
    }

    public List<Student> findAllStudents() {

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
    public List<Teacher> findAllTeachers() {

        List<Teacher> allTeachers = new ArrayList<>();

        Iterable<Teacher> teacherList = teacherRepository.findAll();

        teacherList.forEach(allTeachers::add);

        return allTeachers;
    }

    public ResponseEntity<Object> addTeacher(Teacher teacher){
        teacherRepository.save(teacher);

        return ResponseEntity.status(HttpStatus.CREATED).body("New Teacher created successfully");
    }

    public Teacher findByNum(Long number){
        Optional<Teacher> teacherOpt = teacherRepository.findByNum(number);

        if(teacherOpt.isPresent())
            return  teacherOpt.get();

        throw new RuntimeException("Not found for the id " + number);
    }

    public ResponseEntity<Object> deleteTeacher(Long number){
        Optional<Teacher> teacherOpt = teacherRepository.findByNum(number);

        if(teacherOpt.isPresent()){
            Teacher managedTeacherOpt = teacherOpt.get();
            teacherRepository.delete(managedTeacherOpt);
            return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully");
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Teacher doesn't exist.");
        }
    }
    public ResponseEntity<Object> addCourse(Course course){
        courseRepository.save(course);

        return ResponseEntity.status(HttpStatus.CREATED).body("New Course created successfully");
    }
    public Course findById(Long number){
        Optional<Course> courseOpt = courseRepository.findById(number);

        if(courseOpt.isPresent())
            return  courseOpt.get();

        throw new RuntimeException("Not found for the id " + number);
    }
    @Transactional
    public ResponseEntity<Object> addCourseToStudent(Long number1, Long number2){
        Student student = findByNumber(number1);
        Course course = findById(number2);

        student.addCourses(course);
        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.OK).body("New Course added successfully");
    }
    @Transactional
    public ResponseEntity<Object> addCourseToTeacher(Long number1, Long number2){
        Teacher teacher = findByNum(number1);
        Course course = findById(number2);

        teacher.addCourses(course);
        teacherRepository.save(teacher);

        return ResponseEntity.status(HttpStatus.OK).body("New Course added successfully");
    }
    //TODO LOGGER
}
