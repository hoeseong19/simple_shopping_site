package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
    @EmbeddedId
    private ImageId id;

    @Column(name = "url")
    private String url;

    private Image() {
    }

    public Image(ImageId id, String url) {
        this.id = id;
        this.url = url;
    }
}
