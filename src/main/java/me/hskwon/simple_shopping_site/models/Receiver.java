package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.util.Objects;

@Embeddable
public class Receiver {
    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private PhoneNumber phoneNumber;

    private Receiver() {
    }

    public Receiver(String name, Address address, PhoneNumber phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return Objects.equals(name, receiver.name) && Objects.equals(address, receiver.address) && Objects.equals(phoneNumber, receiver.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber);
    }
}
