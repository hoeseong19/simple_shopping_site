package me.hskwon.simple_shopping_site.application.auth;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SignupService {
    private final UserRepository userRepository;

    public SignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup(String email, String name, String password) {
        UserId userId = UserId.generate();
        User newUser = new User(userId, email, name, password);

        userRepository.save(newUser);
    }
}
