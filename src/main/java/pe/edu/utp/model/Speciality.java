package pe.edu.utp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "speciality")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idSpeciality;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    public Speciality() { }

    public Speciality(Long idSpeciality, String name, List<Teacher> teachers) {
        this.idSpeciality = idSpeciality;
        this.name = name;
        this.teachers = teachers;
    }

    public Long getIdSpeciality() { return idSpeciality; }

    public void setIdSpeciality(Long idSpeciality) { this.idSpeciality = idSpeciality; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Teacher> getTeachers() { return teachers; }

    public void setTeachers(List<Teacher> teachers) { this.teachers = teachers; }

}
