package me.hskwon.simple_shopping_site.dtos;

import me.hskwon.simple_shopping_site.models.User;

public record UserDto(
        String id
) {
    public static UserDto of(User user) {
        return new UserDto(
                user.id().toString()
        );
    }
}
