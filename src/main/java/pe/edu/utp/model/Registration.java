package pe.edu.utp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idRegistration;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(nullable = false)
    private Date registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus status;

    @Column(nullable = false)
    private Long grade;

    @Column(nullable = false)
    private String studyLevel;

    public Registration() { }

    public Registration(Long idRegistration, User user, Date registrationDate, RegistrationStatus status, Long grade, String studyLevel) {
        this.idRegistration = idRegistration;
        this.user = user;
        this.registrationDate = registrationDate;
        this.status = status;
        this.grade = grade;
        this.studyLevel = studyLevel;
    }

    public Long getIdRegistration() { return idRegistration; }

    public void setIdRegistration(Long idRegistration) { this.idRegistration = idRegistration; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Date getRegistrationDate() { return registrationDate; }

    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    public RegistrationStatus getStatus() { return status; }

    public void setStatus(RegistrationStatus status) { this.status = status; }

    public Long getGrade() { return grade; }

    public void setGrade(Long grade) { this.grade = grade; }

    public String getStudyLevel() { return studyLevel; }

    public void setStudyLevel(String studyLevel) { this.studyLevel = studyLevel; }
}
