package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ImageId extends EntityId {
    private ImageId() {
        super();
    }

    public ImageId(String value) {
        super(value);
    }
}
