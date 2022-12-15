package vn.banhang.Model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private String message;
    private boolean status;
    private Date createAt;
    private int typeMess;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notification(String subject, String message, int typeMess, User user) {
        this.subject = subject;
        this.message = message;
        this.status = true;
        this.createAt = new Date();
        this.typeMess = typeMess;
        this.user = user;
    }

    public Notification() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getTypeMess() {
        return typeMess;
    }

    public void setTypeMess(int typeMess) {
        this.typeMess = typeMess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

