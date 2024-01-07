package me.hskwon.simple_shopping_site.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateOrderDto(
        ReceiverDto receiver,
        PaymentDto payment
) {
    public record ReceiverDto(
            @NotBlank
            String name,
            @NotBlank
            String address1,
            @NotBlank
            String address2,
            @NotBlank
            String postalCode,
            @NotBlank
            String phoneNumber
    ) {
    }

    public record PaymentDto(
            @NotBlank
            String merchantId,
            @NotBlank
            String transactionId
    ) {
    }
}
