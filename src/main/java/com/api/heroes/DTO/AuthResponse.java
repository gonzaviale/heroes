package com.api.heroes.DTO;

import com.api.heroes.models.enumerators.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    Role role;
}
