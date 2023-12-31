package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.security.AuthUserDao;
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
    private AuthUserDao authUserDao;
    private AccessTokenGenerator accessTokenGenerator;

    @BeforeEach
    void setUp() {
        authUserDao = mock(AuthUserDao.class);
        accessTokenGenerator = mock(AccessTokenGenerator.class);

        loginService = new LoginService(authUserDao, accessTokenGenerator);
    }

    @Test
    @DisplayName("login")
    void testLogin() {
        String email = "a@b.c";
        String password = "password";

        loginService.login(email, password);

        verify(accessTokenGenerator).generate("");
    }
}