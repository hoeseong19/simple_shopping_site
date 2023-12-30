package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.auth.SignupService;
import me.hskwon.simple_shopping_site.dtos.SignupRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SignupService signupService;

    public UserController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String signUp(
            @RequestBody SignupRequestDto dto
    ) {
        signupService.signup(
                dto.email(),
                dto.name(),
                dto.password()
        );

        return "";
    }
}
