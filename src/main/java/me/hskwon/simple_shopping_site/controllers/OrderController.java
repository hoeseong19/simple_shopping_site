package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.orders.CreateOrderService;
import me.hskwon.simple_shopping_site.dtos.CreateOrderDto;
import me.hskwon.simple_shopping_site.models.*;
import me.hskwon.simple_shopping_site.security.AuthUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderService createOrderService;

    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(
            Authentication authentication,
            @RequestBody CreateOrderDto dto
    ) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();

        UserId userId = new UserId(authUser.id());

        Receiver receiver = new Receiver(
                dto.receiver().name(),
                new Address(
                        dto.receiver().address1(),
                        dto.receiver().address2(),
                        new PostalCode(dto.receiver().postalCode())
                ),
                new PhoneNumber(
                        dto.receiver().phoneNumber()
                )
        );

        Payment payment = new Payment(
                dto.payment().merchantId(),
                dto.payment().transactionId()
        );

        createOrderService.createOrder(
                userId,
                receiver,
                payment
        );
    }
}
