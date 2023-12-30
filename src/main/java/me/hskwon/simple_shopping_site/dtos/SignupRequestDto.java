package me.hskwon.simple_shopping_site.dtos;

public record SignupRequestDto(
        String email,
        String name,
        String password
) {
}
