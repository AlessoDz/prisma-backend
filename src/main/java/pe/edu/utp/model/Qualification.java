package pe.edu.utp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idQualification;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class class_;

    @Column(nullable = false)
    private int bimester;
    @Column(nullable = false)
    private int value;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Class course;

    public Qualification() { }

    public Qualification(Long idQualification, Student student, Class class_, int bimester, int value, Class course) {
        this.idQualification = idQualification;
        this.student = student;
        this.class_ = class_;
        this.bimester = bimester;
        this.value = value;
        this.course = course;
    }

    public Long getIdQualification() { return idQualification; }

    public void setIdQualification(Long idQualification) { this.idQualification = idQualification; }

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    public Class getClass_() { return class_; }

    public void setClass_(Class class_) { this.class_ = class_; }

    public int getBimester() { return bimester; }

    public void setBimester(int bimester) { this.bimester = bimester; }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public Class getCourse() {
        return course;
    }

    public void setCourse(Class course) {
        this.course = course;
    }
}
