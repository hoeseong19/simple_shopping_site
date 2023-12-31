package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.security.AuthUser;
import me.hskwon.simple_shopping_site.security.AuthUserDao;
import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    private PasswordEncoder passwordEncoder;
    private AccessTokenGenerator accessTokenGenerator;

    @BeforeEach
    void setUp() {
        authUserDao = mock(AuthUserDao.class);
        passwordEncoder = mock(PasswordEncoder.class);
        accessTokenGenerator = mock(AccessTokenGenerator.class);

        loginService = new LoginService(authUserDao, passwordEncoder, accessTokenGenerator);
    }

    @Test
    @DisplayName("login - with valid email")
    void testLoginWithValidEmail() {
        String userId = "userId";
        String email = "a@b.c";
        String encodedPassword = "encodedPassword";
        String role = ROLE_USER.toString();
        String accessToken = "accessToken";
        AuthUser authUser = AuthUser.of(
                userId,
                email,
                encodedPassword,
                role
        );

        String rawPassword = "rawPassword";

        given(authUserDao.findByEmail(email))
                .willReturn(Optional.of(authUser));

        given(passwordEncoder.matches(rawPassword, encodedPassword))
                .willReturn(true);

        given(accessTokenGenerator.generate(userId))
                .willReturn(accessToken);

        String generatedAccessToken = loginService.login(email, rawPassword);

        assertThat(generatedAccessToken).isEqualTo(accessToken);

        verify(authUserDao).addAccessToken(accessToken, userId);
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

    @Test
    @DisplayName("login - with invalid password")
    void testLoginWithInvalidPassword() {
        String userId = "userId";
        String email = "a@b.c";
        String encodedPassword = "encodedPassword";
        String role = ROLE_USER.toString();
        AuthUser authUser = AuthUser.of(
                userId,
                email,
                encodedPassword,
                role
        );

        String rawPassword = "rawPassword";

        given(authUserDao.findByEmail(email))
                .willReturn(Optional.of(authUser));

        given(passwordEncoder.matches(rawPassword, encodedPassword))
                .willReturn(false);

        assertThatThrownBy(() -> loginService.login(email, encodedPassword))
                .isInstanceOf(BadCredentialsException.class);

        verify(accessTokenGenerator, never()).generate(any());
    }
}