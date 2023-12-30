package me.hskwon.simple_shopping_site.security;

import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AccessTokenServiceTest {
    private AccessTokenService accessTokenService;
    private AccessTokenGenerator accessTokenGenerator;
    private AuthUserDao authUserDao;

    @BeforeEach
    void setUp() {
        accessTokenGenerator = mock(AccessTokenGenerator.class);
        authUserDao = mock(AuthUserDao.class);

        accessTokenService = new AccessTokenService(
                accessTokenGenerator,
                authUserDao
        );
    }

    @Test
    @DisplayName("authenticate - with valid token")
    void testAuthenticateWithValidToken() {
        String accessToken = "accessToken";

        given(accessTokenGenerator.verify(accessToken)).willReturn(true);

        given(authUserDao.findByAccessToken(accessToken))
                .willReturn(Optional.of(mock(AuthUser.class)));

        Authentication authentication = accessTokenService
                .authenticate(accessToken);

        assertThat(authentication).isNotNull();
    }

    @Test
    @DisplayName("authenticate - with invalid token")
    void testAuthenticateWithInvalidToken() {
        String accessToken = "accessToken";

        given(accessTokenGenerator.verify(accessToken)).willReturn(false);

        Authentication authentication = accessTokenService
                .authenticate(accessToken);

        assertThat(authentication).isNull();
    }

    @Test
    @DisplayName("authenticate - with no user token")
    void testAuthenticateWithNoUserToken() {
        String accessToken = "accessToken";

        given(accessTokenGenerator.verify(accessToken)).willReturn(true);

        given(authUserDao.findByAccessToken(accessToken))
                .willReturn(Optional.empty());

        Authentication authentication = accessTokenService
                .authenticate(accessToken);

        assertThat(authentication).isNull();
    }
}