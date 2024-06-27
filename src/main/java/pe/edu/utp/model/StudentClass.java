package pe.edu.utp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_class_assignment")
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idAssignment;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_class", nullable = false)
    private Class class_;

    public StudentClass() { }

    public StudentClass(int idAssignment, Student student, Class class_) {
        this.idAssignment = idAssignment;
        this.student = student;
        this.class_ = class_;
    }

    public int getIdAssignment() { return idAssignment; }

    public void setIdAssignment(int idAssignment) { this.idAssignment = idAssignment; }

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    public Class getClass_() { return class_; }

    public void setClass_(Class class_) { this.class_ = class_; }

}
