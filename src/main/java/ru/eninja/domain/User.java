package ru.eninja.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * User Entity
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    @NotNull
    private Long id;

    /**
     * Login column
     */
    @Column(name = "login", nullable = false, unique = true, length = 20)
    @NotNull
    @Size(min = 3, max = 20)
    private String login;

    /**
     * Password column
     */
    @Column(name = "password", nullable = false, length = 20)
    @NotNull
    @Size(min = 6, max = 20)
    private String password;

    /**
     * Email column
     */
    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    @Email
    private String email;

    /**
     * Role column (user, admin..)
     */
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;

    /**
     * JPA requires to define default-constructor
     */
    public User() {
    }

    /**
     * Full parametrized constructor
     */
    public User(Long id, String login, String password, String email, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     * Almost full parametrized constructor (without id)
     */
    public User(String login, String password, String email, Role role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        return role.equals(user.role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
