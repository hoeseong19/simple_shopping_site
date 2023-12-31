package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.auth.SignupService;
import me.hskwon.simple_shopping_site.application.users.GetUserService;
import me.hskwon.simple_shopping_site.exceptions.EmailAlreadyExistException;
import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static me.hskwon.simple_shopping_site.models.Role.ROLE_USER;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SignupService signupService;

    @MockBean
    GetUserService getUserService;

    @Test
    @DisplayName("POST /users - with valid info")
    void testSignupWithValidInfo() throws Exception {
        String email = "a@b.c";
        String name = "name";
        String password = "password";
        String json = """
                {
                    "email": "%s",
                    "name": "%s",
                    "password": "%s"
                }
                """.formatted(email, name, password);

        RequestBuilder requestBuilder = post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("accessToken")));

        verify(signupService).signup(email, name, password);
    }

    @Test
    @DisplayName("POST /users - with signed email")
    void testSignupWithSignedEmail() throws Exception {
        String email = "a@b.c";
        String name = "name";
        String password = "password";
        String json = """
                {
                    "email": "%s",
                    "name": "%s",
                    "password": "%s"
                }
                """.formatted(email, name, password);

        doThrow(EmailAlreadyExistException.class)
                .when(signupService)
                .signup(email, name, password);

        RequestBuilder requestBuilder = post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Email Already Exists")));

        verify(signupService).signup(email, name, password);
    }

    @Test
    @DisplayName("GET /users/me")
    void testMe() throws Exception {
        UserId userId = new UserId(USER_ID);
        User user = new User(
                userId,
                "email",
                "name",
                "password",
                ROLE_USER
        );

        given(getUserService.getUser(any()))
                .willReturn(user);

        RequestBuilder requestBuilder = get("/users/me")
                .header("Authorization", "Bearer %s".formatted(accessToken));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}