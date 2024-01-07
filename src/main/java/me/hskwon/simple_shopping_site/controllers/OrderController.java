package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.orders.CreateOrderService;
import me.hskwon.simple_shopping_site.dtos.CreateOrderDto;
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
        createOrderService.createOrder();
    }
}
