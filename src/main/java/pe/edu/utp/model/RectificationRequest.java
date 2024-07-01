package pe.edu.utp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RectificationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRectificationRequest;
    private Long studentId;
    private Long gradeId;
    private String reason;
    private String status; // e.g., "PENDING", "APPROVED", "DENIED"

    public RectificationRequest() {
    }

    public RectificationRequest(Long idRectificationRequest, Long studentId, Long gradeId, String reason, String status) {
        this.idRectificationRequest = idRectificationRequest;
        this.studentId = studentId;
        this.gradeId = gradeId;
        this.reason = reason;
        this.status = status;
    }

    public Long getIdRectificationRequest() {
        return idRectificationRequest;
    }

    public void setIdRectificationRequest(Long id) {
        this.idRectificationRequest = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
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
