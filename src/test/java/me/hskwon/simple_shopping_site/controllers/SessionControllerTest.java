package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.auth.LoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SessionController.class)
class SessionControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    LoginService loginService;

    @Test
    @DisplayName("POST /session")
    void testLogin() throws Exception {
        String username = "username";
        String password = "password";

        String json = """
                {
                    "username": "%s",
                    "password": "%s"
                }
                """.formatted(username, password);

        RequestBuilder requestBuilder = post("/session")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());

        verify(loginService).login(username, password);
    }
}