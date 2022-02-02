package sti.example.projectjavablinn.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_teacher")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private Long num;
    private int hourlyPay;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public void addCourses(Course course) {
        this.courses.add(course);
    }

    public void setCourses(Set<Course> courses) {

    }
}
