package com.api.heroes.DTO;

import com.api.heroes.models.enumerators.Role;

public class RegisterDTO {
    private String name;
    private String email;
    private String username;
    private String password;
    private Role role;
    private BankDTO bank;
    private VeterinarianDTO veterinarian;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public VeterinarianDTO getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(VeterinarianDTO veterinarian) {
        this.veterinarian = veterinarian;
    }
}
