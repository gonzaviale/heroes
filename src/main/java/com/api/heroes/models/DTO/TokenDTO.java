package com.api.heroes.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenDTO(
    @JsonProperty("access_token")
    String accessToken,
    @JsonProperty("refresh_token")
    String refreshToken
) {
}
