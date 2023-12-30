package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserId extends EntityId {
    private UserId() {
        super();
    }

    public UserId(String value) {
        super(value);
    }
}
