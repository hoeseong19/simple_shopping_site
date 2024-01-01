package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.cart.AddProductToCartService;
import me.hskwon.simple_shopping_site.models.ProductId;
import me.hskwon.simple_shopping_site.models.ProductOptionId;
import me.hskwon.simple_shopping_site.models.ProductOptionItemId;
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

@WebMvcTest(CartLineItemController.class)
class CartLineItemControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AddProductToCartService addProductToCartService;

    @Test
    @DisplayName("POST /cart/line-items")
    void testAddProduct() throws Exception {
        ProductId productId = new ProductId("productId");
        ProductOptionId optionId = new ProductOptionId("optionId");
        ProductOptionItemId optionItemId = new ProductOptionItemId("optionItemId");
        int quantity = 2;

        String json = """
                {
                    "productId": "%s",
                    "options": [
                        {
                             "id": "%s",
                             "itemId": "%s"
                         }
                    ],
                    "quantity": %d
                }
                """
                .formatted(
                        productId.toString(),
                        optionId.toString(),
                        optionItemId.toString(),
                        quantity
                );

        RequestBuilder requestBuilder = post("/cart/line-items")
                .header("Authorization", "Bearer %s".formatted(accessToken))
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        verify(addProductToCartService).addProduct(any(), any(), any(), eq(quantity));
    }
}