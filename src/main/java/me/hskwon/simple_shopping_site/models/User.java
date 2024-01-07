package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity<UserId> {
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    private User() {
        super();
    }

    public User(UserId id, String email, String name, String password, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public UserId id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String name() {
        return name;
    }
}
