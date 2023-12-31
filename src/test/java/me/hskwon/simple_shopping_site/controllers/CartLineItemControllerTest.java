package me.hskwon.simple_shopping_site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CartLineItemController.class)
class CartLineItemControllerTest {
    @Autowired
    MockMvc mockMvc;
}