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

    public Optional<AuthUser> findByAccessToken(String accessToken) {
        String sql = """
                SELECT u.id, u.role
                FROM users u JOIN access_tokens at2 on u.id = at2.user_id
                WHERE at2.value = ?
                """;

        return jdbcTemplate.query(
                sql,
                resultSet -> {
                    if (!resultSet.next()) {
                        return Optional.empty();
                    }

                    AuthUser authUser = AuthUser.authenticated(
                            resultSet.getString("id"),
                            resultSet.getString("role"),
                            accessToken
                    );

                    return Optional.of(authUser);
                },
                accessToken
        );
    }

    public Optional<AuthUser> findByEmail(String email) {
        String sql = """
                SELECT id, password, role
                FROM users
                WHERE email = ?;
                """;

        return jdbcTemplate.query(
                sql,
                resultSet -> {
                    if (!resultSet.next()) {
                        return Optional.empty();
                    }

                    AuthUser authUser = AuthUser.of(
                            resultSet.getString("id"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("role")
                    );

                    return Optional.of(authUser);
                },
                email);
    }
}
