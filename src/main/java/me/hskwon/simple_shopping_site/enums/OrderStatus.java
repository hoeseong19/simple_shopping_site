package me.hskwon.simple_shopping_site.enums;

public enum OrderStatus {
    PAID("paid");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
