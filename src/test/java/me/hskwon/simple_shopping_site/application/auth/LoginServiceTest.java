package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class LoginServiceTest {
    private LoginService loginService;

    private AccessTokenGenerator accessTokenGenerator;

    @BeforeEach
    void setUp() {
        accessTokenGenerator = mock(AccessTokenGenerator.class);

        loginService = new LoginService(accessTokenGenerator);
    }

    @Test
    @DisplayName("login")
    void testLogin() {
        String username = "username";
        String password = "password";

        loginService.login(username, password);

        verify(accessTokenGenerator).generate();
    }
}