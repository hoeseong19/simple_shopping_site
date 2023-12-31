package me.hskwon.simple_shopping_site.application.auth;

import jakarta.transaction.Transactional;
import me.hskwon.simple_shopping_site.exceptions.EmailAlreadyExistException;
import me.hskwon.simple_shopping_site.models.Role;
import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.repositories.UserRepository;
import me.hskwon.simple_shopping_site.security.AuthUserDao;
import me.hskwon.simple_shopping_site.utils.AccessTokenGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SignupService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AccessTokenGenerator accessTokenGenerator;

    private final AuthUserDao authUserDao;

    public SignupService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AccessTokenGenerator accessTokenGenerator,
            AuthUserDao authUserDao) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenGenerator = accessTokenGenerator;
        this.authUserDao = authUserDao;
    }

    public String signup(String email, String name, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistException();
        }

        UserId userId = UserId.generate();
        String encodedPassword = passwordEncoder.encode(password);
        Role role = Role.ROLE_USER;
        User newUser = new User(userId, email, name, encodedPassword, role);

        userRepository.save(newUser);

        String accessToken = accessTokenGenerator.generate(userId.toString());

        authUserDao.addAccessToken(accessToken, userId.toString());

        return accessToken;
    }
}
