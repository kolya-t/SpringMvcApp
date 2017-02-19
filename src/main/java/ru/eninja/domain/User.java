package ru.eninja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * User Entity
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity<Long> {

    /**
     * Login column
     */
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    /**
     * Password column
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Email column
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Role column (user, admin..)
     */
    @Column(name = "role", nullable = false)
    private String role;

    /**
     * JPA requires to define default-constructor
     */
    public User() {
    }

    /**
     * Full parametrized constructor
     */
    public User(Long id, String login, String password, String email, String role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        setId(id);
    }

    /**
     * Almost full parametrized constructor (without id)
     */
    public User(String login, String password, String email, String role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
