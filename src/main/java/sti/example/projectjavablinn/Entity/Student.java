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
    @Column(name = "id", nullable = false)
    private Long id;


    private String firstName;
    private String lastName;
    private Long number;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "tbl_student_course",
            joinColumns = {@JoinColumn(name = "tbl_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "tbl_course_id")}
    )
    private Set<Course> courses;

}
