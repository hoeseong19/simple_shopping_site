package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.exceptions.EmailAlreadyExistException;
import me.hskwon.simple_shopping_site.repositories.UserRepository;
import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class SignupServiceTest {
    private SignupService signupService;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private AccessTokenGenerator accessTokenGenerator;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        accessTokenGenerator = mock(AccessTokenGenerator.class);

        signupService = new SignupService(userRepository, passwordEncoder, accessTokenGenerator);
    }

    @Test
    @DisplayName("signup - with new email")
    void testSignupWithNewEmail() {
        String email = "a@b.c";
        String name = "name";
        String password = "password";

        given(userRepository.existsByEmail(email)).willReturn(false);

        String accessToken = signupService.signup(email, name, password);

        assertThat(accessToken).isBlank();

        verify(passwordEncoder).encode(password);
        verify(userRepository).save(any());
        verify(accessTokenGenerator).generate(any());
    }

    @Test
    @DisplayName("signup - with existing email")
    void testSignupWithExistingEmail() {
        String email = "a@b.c";
        String name = "name";
        String password = "password";

        given(userRepository.existsByEmail(email)).willReturn(true);

        assertThatThrownBy(() -> signupService.signup(email, name, password))
                .isInstanceOf(EmailAlreadyExistException.class);

        verify(passwordEncoder, never()).encode(password);
        verify(userRepository, never()).save(any());
        verify(accessTokenGenerator, never()).generate(any());
    }
}