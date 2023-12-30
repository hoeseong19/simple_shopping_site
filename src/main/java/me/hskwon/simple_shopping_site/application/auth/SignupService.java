package me.hskwon.simple_shopping_site.application.auth;

import me.hskwon.simple_shopping_site.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    private final UserRepository userRepository;

    public SignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
