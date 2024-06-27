package pe.edu.utp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idNotification;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private Date creationDate;
    @Column(nullable = false)
    private boolean revised;

    public Notification() { }

    public Notification(Long idNotification, User user, String title, String message, Date creationDate, boolean revised) {
        this.idNotification = idNotification;
        this.user = user;
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.revised = revised;
    }

    public Long getIdNotification() { return idNotification; }

    public void setIdNotification(Long idNotification) { this.idNotification = idNotification; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public Date getCreationDate() { return creationDate; }

    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public boolean isRevised() { return revised; }

    public void setRevised(boolean revised) { this.revised = revised; }

}
