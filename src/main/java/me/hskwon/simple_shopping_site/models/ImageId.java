package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ImageId {
    @Column(name = "id")
    private String value;

    private ImageId() {
    }

    public ImageId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
