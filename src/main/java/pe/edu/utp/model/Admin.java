package pe.edu.utp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(length = 10, nullable = false)
    private String idAdmin;

    @OneToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String profile;

    public Admin() { }

    public Admin(String idAdmin, User user, String password, String profile) {
        this.idAdmin = idAdmin;
        this.user = user;
        this.password = password;
        this.profile = profile;
    }

    public String getIdAmin() { return idAdmin; }

    public void setIdAmin(String idAmin) { this.idAdmin = idAmin; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

}
