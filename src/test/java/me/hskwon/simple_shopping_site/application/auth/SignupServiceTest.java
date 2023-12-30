package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class SignupServiceTest {
    private SignupService signupService;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);

        signupService = new SignupService(userRepository);
    }
}