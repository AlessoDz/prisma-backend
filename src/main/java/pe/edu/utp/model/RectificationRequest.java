package pe.edu.utp.model;

import jakarta.persistence.*;

@Entity
public class RectificationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRectificationRequest;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_qualification")
    private Qualification qualification;

    private String reason;
    private String status; // e.g., "PENDING", "APPROVED", "DENIED"

    public RectificationRequest() {
    }

    public RectificationRequest(Long idRectificationRequest, Student student, Qualification qualification, String reason, String status) {
        this.idRectificationRequest = idRectificationRequest;
        this.student = student;
        this.qualification = qualification;
        this.reason = reason;
        this.status = status;
    }

    public Long getIdRectificationRequest() {
        return idRectificationRequest;
    }

    public void setIdRectificationRequest(Long idRectificationRequest) {
        this.idRectificationRequest = idRectificationRequest;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
