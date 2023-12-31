package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.auth.SignupService;
import me.hskwon.simple_shopping_site.application.users.GetUserService;
import me.hskwon.simple_shopping_site.dtos.SignupRequestDto;
import me.hskwon.simple_shopping_site.dtos.SignupResultDto;
import me.hskwon.simple_shopping_site.dtos.UserDto;
import me.hskwon.simple_shopping_site.exceptions.EmailAlreadyExistException;
import me.hskwon.simple_shopping_site.models.User;
import me.hskwon.simple_shopping_site.models.UserId;
import me.hskwon.simple_shopping_site.security.AuthUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SignupService signupService;

    private final GetUserService getUserService;

    public UserController(SignupService signupService, GetUserService getUserService) {
        this.signupService = signupService;
        this.getUserService = getUserService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SignupResultDto signUp(
            @RequestBody SignupRequestDto dto
    ) {
        String accessToken = signupService.signup(
                dto.email(),
                dto.name(),
                dto.password()
        );

        return SignupResultDto.of(accessToken);
    }

    @GetMapping("/me")
    public UserDto me(Authentication authentication) {
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        UserId userId = new UserId(authUser.id());
        User user = getUserService.getUser(userId);
        return UserDto.of(user);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emailAlreadyExist() {
        return "Email Already Exists";
    }
}
