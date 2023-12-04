package SkillBox.com.users.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "subscriptions")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String subscription;
    private boolean deleted = Boolean.FALSE;

    public Subscriptions() {
    }

    public Subscriptions(String userId, String subscription, Boolean deleted) {
        this.userId = userId;
        this.subscription = subscription;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", subscription='" + subscription + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
