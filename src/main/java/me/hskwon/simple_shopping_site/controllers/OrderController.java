package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.orders.CreateOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderService createOrderService;

    public OrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder() {
    }
}
