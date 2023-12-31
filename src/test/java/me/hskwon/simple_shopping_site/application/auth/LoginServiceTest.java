package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.security.AuthUser;
import me.hskwon.simple_shopping_site.security.AuthUserDao;
import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.Optional;

import static me.hskwon.simple_shopping_site.models.Role.ROLE_USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
    @DisplayName("login - with valid email")
    void testLoginWithValidEmail() {
        String userId = "userId";
        String email = "a@b.c";
        String password = "password";
        String role = ROLE_USER.toString();
        String accessToken = "accessToken";
        AuthUser authUser = AuthUser.of(
                userId,
                email,
                password,
                role
        );

        given(authUserDao.findByEmail(email))
                .willReturn(Optional.of(authUser));

        given(accessTokenGenerator.generate(userId))
                .willReturn(accessToken);

        String generatedAccessToken = loginService.login(email, password);

        assertThat(generatedAccessToken).isEqualTo(accessToken);

        verify(accessTokenGenerator).generate(userId);
    }

    @Test
    @DisplayName("login - with invalid email")
    void testLoginWithInvalidEmail() {
        String email = "a@b.c";
        String password = "password";

        given(authUserDao.findByEmail(email))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> loginService.login(email, password))
                .isInstanceOf(BadCredentialsException.class);

        verify(accessTokenGenerator, never()).generate(any());
    }
}