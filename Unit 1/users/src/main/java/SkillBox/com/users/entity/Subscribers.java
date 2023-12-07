package SkillBox.com.users.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "subscribers")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Subscribers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    private String subscriberId;
    private boolean deleted = Boolean.FALSE;

    public Subscribers() {
    }

    public Subscribers(String userId, String subscriberId, Boolean deleted) {
        this.userId = userId;
        this.subscriberId = subscriberId;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
