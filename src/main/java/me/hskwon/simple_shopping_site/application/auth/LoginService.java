package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final AccessTokenGenerator accessTokenGenerator;

    public LoginService(AccessTokenGenerator accessTokenGenerator) {
        this.accessTokenGenerator = accessTokenGenerator;
    }

    public String login(String username, String password) {
        return accessTokenGenerator.generate();
    }
}
