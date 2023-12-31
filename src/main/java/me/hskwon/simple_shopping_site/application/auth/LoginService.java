package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.security.AuthUserDao;
import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final AuthUserDao authUserDao;

    private final AccessTokenGenerator accessTokenGenerator;

    public LoginService(AuthUserDao authUserDao, AccessTokenGenerator accessTokenGenerator) {
        this.authUserDao = authUserDao;
        this.accessTokenGenerator = accessTokenGenerator;
    }

    public String login(String email, String password) {
        return accessTokenGenerator.generate("");
    }
}
