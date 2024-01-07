package me.hskwon.simple_shopping_site.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Payment {
    @Column(name = "payment_merchant_id")
    private String merchantId;

    @Column(name = "payment_transaction_id")
    private String transactionId;

    private Payment() {
    }

    public Payment(String merchantId, String transactionId) {
        this.merchantId = merchantId;
        this.transactionId = transactionId;
    }

    public String merchantId() {
        return merchantId;
    }

    public String transactionId() {
        return transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(merchantId, payment.merchantId) && Objects.equals(transactionId, payment.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, transactionId);
    }
}
