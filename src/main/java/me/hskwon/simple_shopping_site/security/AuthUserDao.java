package me.hskwon.simple_shopping_site.security;

import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Transactional
public class AuthUserDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addAccessToken(String accessToken, String userId) {
        String sql = """
                INSERT INTO access_tokens (value, user_id)
                VALUES (?, ?);
                """;

        jdbcTemplate.update(
                sql,
                accessToken, userId
        );
    }
}
