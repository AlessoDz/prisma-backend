package pe.edu.utp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(length = 10, nullable = false)
    private String idTeacher;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_speciality")
    private Speciality speciality;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String profile;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Class> classes;

    public Teacher() { }

    public Teacher(String idTeacher, User user, Speciality speciality, String password, String profile, List<Class> classes) {
        this.idTeacher = idTeacher;
        this.user = user;
        this.speciality = speciality;
        this.password = password;
        this.profile = profile;
        this.classes = classes;
    }

    public String getIdTeacher() { return idTeacher; }

    public void setIdTeacher(String idTeacher) { }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Speciality getSpeciality() { return speciality; }

    public void setSpeciality(Speciality speciality) { this.speciality = speciality; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public List<Class> getClasses() { return classes; }

    public void setClasses(List<Class> classes) { this.classes = classes; }

}
