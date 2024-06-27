package pe.edu.utp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @Column(length = 10, nullable = false)
    private String idApplicant;

    @OneToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    public Applicant() { }

    public String getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(String idApplicant) {
        this.idApplicant = idApplicant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
