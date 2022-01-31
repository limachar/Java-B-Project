package sti.example.projectjavablinn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sti.example.projectjavablinn.Entity.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Optional<Student> findById(Long id);

}
