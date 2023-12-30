package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SignupServiceTest {
    private SignupService signupService;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);

        signupService = new SignupService(userRepository, passwordEncoder);
    }

    @Test
    @DisplayName("signup")
    void testSignup() {
        String email = "a@b.c";
        String name = "name";
        String password = "password";

        signupService.signup(email, name, password);

        verify(passwordEncoder).encode(password);
        verify(userRepository).save(any());
    }
}