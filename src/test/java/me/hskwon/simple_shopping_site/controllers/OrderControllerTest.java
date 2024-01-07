package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.Fixtures;
import me.hskwon.simple_shopping_site.application.orders.CreateOrderService;
import me.hskwon.simple_shopping_site.models.Payment;
import me.hskwon.simple_shopping_site.models.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest extends ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateOrderService createOrderService;

    @Test
    @DisplayName("POST /orders")
    void testCreateOrder() throws Exception {
        Receiver receiver = Fixtures.receiver();
        Payment payment = Fixtures.payment();

        String json = """
                {
                    "receiver": {
                        "name": "%s",
                        "address1": "%s",
                        "address2": "%s",
                        "postalCode": "%s",
                        "phoneNumber": "%s"
                    },
                    "payment": {
                        "merchantId": "%s",
                        "transactionId": "%s"
                    }
                }
                """
                .formatted(
                        receiver.name(),
                        receiver.address().address1(),
                        receiver.address().address2(),
                        receiver.address().postalCode().toString(),
                        receiver.phoneNumber().toString(),
                        payment.merchantId(),
                        payment.transactionId()
                );

        RequestBuilder requestBuilder = post("/orders")
                .header("Authorization", "Bearer %s".formatted(accessToken))
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        verify(createOrderService).createOrder(any(), eq(receiver), eq(payment));
    }
}