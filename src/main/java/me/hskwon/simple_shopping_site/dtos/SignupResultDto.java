package me.hskwon.simple_shopping_site.dtos;

public record SignupResultDto(
        String accessToken
) {
    public static SignupResultDto of(String accessToken) {
        return new SignupResultDto(accessToken);
    }
}
