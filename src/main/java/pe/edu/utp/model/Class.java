package pe.edu.utp.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClass;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private Classroom classroom;

    private String day;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;

    @OneToMany(mappedBy = "class_", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<StudentClass> studentClasses;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Qualification> qualifications;

    public Class() { }

    public Class(Long idClass, Course course, Teacher teacher, Classroom classroom, String day, LocalTime startTime, LocalTime endTime, List<StudentClass> studentClasses, List<Qualification> qualifications) {
        this.idClass = idClass;
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentClasses = studentClasses;
        this.qualifications = qualifications;
    }

    public Long getIdClass() { return idClass; }

    public void setIdClass(Long idClass) { this.idClass = idClass; }

    public Course getCourse() { return course; }

    public void setCourse(Course course) { this.course = course; }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public Classroom getClassroom() { return classroom; }

    public void setClassroom(Classroom classroom) { this.classroom = classroom; }

    public String getDay() { return day; }

    public void setDay(String day) { this.day = day; }

    public LocalTime getStartTime() { return startTime; }

    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }

    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public List<StudentClass> getStudentClasses() { return studentClasses; }

    public void setStudentClasses(List<StudentClass> studentClasses) { this.studentClasses = studentClasses; }

    public List<Qualification> getQualifications() { return qualifications; }

    public void setQualifications(List<Qualification> qualifications) { this.qualifications = qualifications;}

}
