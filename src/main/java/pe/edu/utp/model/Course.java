package pe.edu.utp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCourse;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Class> classes;

    public Course() { }

    public Course(Long idCourse, String name, List<Class> classes) {
        this.idCourse = idCourse;
        this.name = name;
        this.classes = classes;
    }

    public Long getIdCourse() { return idCourse; }

    public void setIdCourse(Long idCourse) { this.idCourse = idCourse; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Class> getClasses() { return classes; }

    public void setClasses(List<Class> classes) { this.classes = classes; }

}
