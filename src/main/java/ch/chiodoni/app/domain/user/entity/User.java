package ch.chiodoni.app.domain.user.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.Years;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 21.11.12
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    public static final int OLDEST_USER = 120;

    @Id
    @TableGenerator(name = "IDS")
    @GeneratedValue(generator = "IDS")
    private Long id;

    @NotEmpty(message = "{validation.user.name.required}")
    @Column(nullable = false, length = 100)
    private String name;

    @NotEmpty(message = "{validation.user.lastName.required}")
    @Column(nullable = false, length = 100)
    private String lastName;

    @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "{validation.user.phone.invalid}")
    @NotEmpty(message = "{validation.user.phone.required}")
    @Column(nullable = false, length = 20)
    private String phone;

    @Email(message = "{validation.user.email.invalid}")
    @NotEmpty(message = "{validation.user.email.required}")
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Past(message = "{validation.user.birthday.invalid}")
    @Column(nullable = true)
    private Date birthday;

    @Column(nullable = true, length = 50)
    private String country;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User() {
        this.status = UserStatus.UNVERIFIED;
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.status = UserStatus.UNVERIFIED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
        status = status.emailVerified();
    }

    public UserStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isUserTooOld() {
        if (birthday == null) {
            // Since not mandatory
            return false;
        }
        return Years.yearsBetween(new DateTime(birthday), new DateTime()).getYears() > OLDEST_USER;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", status=" + status +
                ", country=" + country +
                '}';
    }
}
