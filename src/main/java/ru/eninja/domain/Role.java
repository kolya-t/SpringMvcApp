package ru.eninja.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "authority", nullable = false, unique = true)
    @NotEmpty
    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Role(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return null;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
