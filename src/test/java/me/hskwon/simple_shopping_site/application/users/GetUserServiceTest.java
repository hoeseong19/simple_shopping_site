package me.hskwon.simple_shopping_site.application.users;

import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetUserServiceTest {
    private GetUserService getUserService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);

        getUserService = new GetUserService(userRepository);
    }

    @Test
    @DisplayName("getUser - with valid id")
    void testGetUserWithValidId() {
        UserId userId = new UserId("userId");

        given(userRepository.findById(userId))
                .willReturn(Optional.of(mock(User.class)));

        User user = getUserService.getUser(userId);

        verify(userRepository).findById(userId);
    }

    @Test
    @DisplayName("getUser - with invalid id")
    void testGetUserWithInvalidId() {
        UserId userId = new UserId("userId");

        given(userRepository.findById(userId))
                .willReturn(Optional.empty());

        assertThatThrownBy(() -> getUserService.getUser(userId))
                .isInstanceOf(NoSuchElementException.class);
    }
}