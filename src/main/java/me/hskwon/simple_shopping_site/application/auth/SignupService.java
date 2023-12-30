package me.hskwon.simple_shopping_site.application.auth;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SignupService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public SignupService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(String email, String name, String password) {
        UserId userId = UserId.generate();
        String encodedPassword = passwordEncoder.encode(password);
        User newUser = new User(userId, email, name, encodedPassword);

        userRepository.save(newUser);
    }
}
