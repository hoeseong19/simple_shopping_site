package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.SimpleShoppingSiteApplication;
import me.hskwon.simple_shopping_site.security.AccessTokenService;
import me.hskwon.simple_shopping_site.security.AuthUser;
import me.hskwon.simple_shopping_site.security.AuthUserDao;
import me.hskwon.simple_shopping_site.security.WebSecurityConfig;
import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static me.hskwon.simple_shopping_site.models.Role.ROLE_USER;
import static org.mockito.BDDMockito.given;

@ContextConfiguration(classes = {
        SimpleShoppingSiteApplication.class,
        WebSecurityConfig.class,
})
public abstract class ControllerTest {
    protected static final String USER_ID = "userId";

    protected String accessToken;

    @SpyBean
    protected AccessTokenService accessTokenService;

    @SpyBean
    private AccessTokenGenerator accessTokenGenerator;

    @MockBean
    protected AuthUserDao authUserDao;

    @BeforeEach
    void setUpAuth() {
        accessToken = accessTokenGenerator.generate(USER_ID);

        AuthUser authUser = AuthUser.authenticated(
                USER_ID, ROLE_USER.toString(), accessToken
        );

        given(authUserDao.findByAccessToken(accessToken))
                .willReturn(Optional.of(authUser));
    }
}
