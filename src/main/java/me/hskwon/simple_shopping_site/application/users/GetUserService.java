package me.hskwon.simple_shopping_site.application.users;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GetUserService {
    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(UserId userId) {
        return userRepository.findById(userId)
                .orElseThrow();
    }
}

