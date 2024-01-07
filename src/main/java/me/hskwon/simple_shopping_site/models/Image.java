package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class Image extends BaseEntity<ImageId> {

    @Column(name = "url")
    private String url;

    private Image() {
        super();
    }

    public Image(ImageId id, String url) {
        this.id = id;
        this.url = url;
    }

    public String url() {
        return url;
    }
}
