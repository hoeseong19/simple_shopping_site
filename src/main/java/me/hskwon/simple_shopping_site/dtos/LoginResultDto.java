package me.hskwon.simple_shopping_site.dtos;

public record LoginResultDto(
        String accessToken
) {
    public static LoginResultDto of(String accessToken) {
        return new LoginResultDto(accessToken);
    }
}
