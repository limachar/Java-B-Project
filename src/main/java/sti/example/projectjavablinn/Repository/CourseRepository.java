package sti.example.projectjavablinn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sti.example.projectjavablinn.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
