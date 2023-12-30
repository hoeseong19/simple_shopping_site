package me.hskwon.simple_shopping_site;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class AppRunner implements CommandLineRunner {
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;

    public AppRunner(JdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        transactionTemplate.execute(status -> {
            String sql = """
                    CREATE TABLE IF NOT EXISTS access_tokens (
                        value varchar(255) PRIMARY KEY,
                        user_id varchar(255) NOT NULL,
                        created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
                    )
                    """;

            jdbcTemplate.update(sql);

            return null;
        });
    }
}
