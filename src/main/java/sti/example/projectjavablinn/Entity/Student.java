package sti.example.projectjavablinn.Entity;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;


    private String firstName;
    private String lastName;
    private Long number;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    //TODO add a student without a course? add more courses to a student? ->
    // add an already existing course to new student without it duplicating.

}
