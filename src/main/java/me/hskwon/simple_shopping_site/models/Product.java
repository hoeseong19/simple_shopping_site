package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @EmbeddedId
    private ProductId id;
}
