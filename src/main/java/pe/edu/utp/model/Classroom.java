package pe.edu.utp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idClassroom;

    @Column(nullable = false)
    private String code;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Class> classes;


    public Classroom() { }

    public Classroom(Long idClassroom, String code, List<Class> classes) {
        this.idClassroom = idClassroom;
        this.code = code;
        this.classes = classes;
    }

    public Long getIdClassroom() { return idClassroom; }

    public void setIdClassroom(Long idClassroom) { this.idClassroom = idClassroom; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public List<Class> getClasses() { return classes; }

    public void setClasses(List<Class> classes) { this.classes = classes; }

}
