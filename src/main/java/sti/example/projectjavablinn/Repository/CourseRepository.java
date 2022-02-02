package sti.example.projectjavablinn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sti.example.projectjavablinn.Entity.Course;
import sti.example.projectjavablinn.Entity.Student;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long number);
}
