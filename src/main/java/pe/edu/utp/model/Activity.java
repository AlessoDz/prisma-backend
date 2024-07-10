package pe.edu.utp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    public Activity() {}

    public Activity(String name, Date date, Student student, Teacher teacher) {
        this.name = name;
        this.date = date;
        this.student = student;
        this.teacher = teacher;
    }

    // Getters y setters
    public Long getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Long id) {
        this.idActivity = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
