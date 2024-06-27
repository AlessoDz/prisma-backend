package pe.edu.utp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(length = 10)
    private String idStudent;

    @OneToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String profile;
    @Column(nullable = false)
    private Long grade;
    @Column(nullable = false)
    private String section;
    @Column(nullable = false)
    private String studyLevel;
    @Column(nullable = false)
    private String shift;
    @Column(nullable = false)
    private Date entryDate;
    @Column(nullable = false)
    private boolean paymentStatus;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentClass> classAssignments;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Qualification> qualifications;

    public Student() { }

    public Student(String idStudent, User user, String password, String profile, Long grade, String section, String studyLevel, String shift, Date entryDate, boolean paymentStatus, List<StudentClass> classAssignments, List<Qualification> qualifications) {
        this.idStudent = idStudent;
        this.user = user;
        this.password = password;
        this.profile = profile;
        this.grade = grade;
        this.section = section;
        this.studyLevel = studyLevel;
        this.shift = shift;
        this.entryDate = entryDate;
        this.paymentStatus = paymentStatus;
        this.classAssignments = classAssignments;
        this.qualifications = qualifications;
    }

    public String getIdStudent() { return idStudent; }

    public void setIdStudent(String idStudent) { this.idStudent = idStudent; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public Long getGrade() { return grade; }

    public void setGrade(Long grade) { this.grade = grade; }

    public String getSection() { return section; }

    public void setSection(String section) { this.section = section; }

    public String getStudyLevel() { return studyLevel; }

    public void setStudyLevel(String studyLevel) { this.studyLevel = studyLevel; }

    public String getShift() { return shift; }

    public void setShift(String shift) { this.shift = shift; }

    public Date getEntryDate() { return entryDate; }

    public void setEntryDate(Date entryDate) { this.entryDate = entryDate; }

    public boolean isPaymentStatus() { return paymentStatus; }

    public void setPaymentStatus(boolean paymentStatus) { this.paymentStatus = paymentStatus; }

    public List<StudentClass> getClassAssignments() { return classAssignments; }

    public void setClassAssignments(List<StudentClass> classAssignments) { this.classAssignments = classAssignments; }

    public List<Qualification> getQualifications() { return qualifications; }

    public void setQualifications(List<Qualification> qualifications) { this.qualifications = qualifications; }

}
