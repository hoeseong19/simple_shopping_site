package me.hskwon.simple_shopping_site.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenGenerator {
    private final Algorithm algorithm;

    public AccessTokenGenerator(
            @Value("${jwt.secret}")
            String secret
    ) {
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String generate() {
        return JWT.create().sign(algorithm);
    }
}
