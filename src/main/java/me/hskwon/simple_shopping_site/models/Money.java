package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Money {
    @Column(name = "amount")
    Long amount;

    private Money() {
        super();
    }

    public Money(Long amount) {
        this.amount = amount;
    }

    public Long asLong() {
        return amount;
    }

    public Money times(int quantity) {
        return new Money(amount * quantity);
    }
}
