package com.api.heroes.DTO;

import com.api.heroes.models.enumerators.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDTO {
    private String name;
    private String email;
    private String username;
    private String password;
    private Role role;
    private BankDTO bank;
    private VeterinarianDTO veterinarian;

}
