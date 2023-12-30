package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @EmbeddedId
    private UserId id;

    private User() {
        super();
    }

    public User(UserId id) {
        this.id = id;
    }

    public UserId id() {
        return id;
    }
}
