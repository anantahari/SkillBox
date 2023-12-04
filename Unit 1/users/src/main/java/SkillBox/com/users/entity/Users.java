package SkillBox.com.users.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String birthday;
    private String city;
    private String avatar;
    private String aboutMe;
    private String nickname;
    private String hardSkills;
    private String email;
    private String phone;
    private boolean deleted = Boolean.FALSE;

    public Users() {
    }

    public Users(String firstName, String lastName, String middleName, String gender, String birthday, String city, String avatar, String aboutMe, String nickname, String hardSkills, String email, String phone, Boolean deleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthday = birthday;
        this.city = city;
        this.avatar = avatar;
        this.aboutMe = aboutMe;
        this.nickname = nickname;
        this.hardSkills = hardSkills;
        this.email = email;
        this.phone = phone;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", city='" + city + '\'' +
                ", avatar='" + avatar + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", nickname='" + nickname + '\'' +
                ", hardSkills='" + hardSkills + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
