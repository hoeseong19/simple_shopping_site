package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.application.auth.LoginService;
import me.hskwon.simple_shopping_site.dtos.LoginRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {
    public SessionController(LoginService loginService) {
        this.loginService = loginService;
    }

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequestDto dto) {
        return loginService.login(
                dto.username(),
                dto.password()
        );
    }
}
