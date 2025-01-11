package com.api.heroes.services;

import com.api.heroes.DTO.AuthResponse;
import com.api.heroes.DTO.LoginDTO;
import com.api.heroes.DTO.RegisterDTO;
import com.api.heroes.models.BankModel;
import com.api.heroes.models.VeterinarianModel;
import com.api.heroes.models.enumerators.Role;
import com.api.heroes.models.UserModel;
import com.api.heroes.models.enumerators.Status;
import com.api.heroes.repositories.IBankRepository;
import com.api.heroes.repositories.IUserRepository;
import com.api.heroes.repositories.IVeterinarianRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final IBankRepository bankRepository;
    private final IVeterinarianRepository veterinarianRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user= userRepository.findByUsername(request.getUsername()).orElseThrow();
        UserModel userModel = userRepository.findByUsername(request.getUsername()).orElseThrow();
        if (userModel.getRole() == Role.BANK) {
            BankModel bank = bankRepository.findByUser(userModel).orElseThrow();
            if (bank.getStatus() == Status.REFUSED || bank.getStatus() == Status.UNDER_REVIEW) {
                throw new RuntimeException("Bank is refused");
            }
        }
        if (userModel.getRole() == Role.VETERINARIAN) {
            VeterinarianModel veterinarian = veterinarianRepository.findByUser(userModel).orElseThrow();
            if (veterinarian.getStatus() == Status.REFUSED || veterinarian.getStatus() == Status.UNDER_REVIEW) {
                throw new RuntimeException("Veterinarian is refused");
            }
        }
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterDTO request) {
        UserModel user = UserModel.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .name(request.getName())
                .email(request.getEmail())
                .role(request.getRole())
                .build();

        UserModel savedUser = userRepository.save(user);
        createSecondaryClass(request, savedUser);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

    private void createSecondaryClass(RegisterDTO request, UserModel savedUser) {
        if (request.getRole() != Role.USER) {
            createBank(request, savedUser);
            createVeterinarian(request, savedUser);
        }
    }

    private void createBank(RegisterDTO request, UserModel savedUser) {
        if (request.getRole() != Role.BANK) return;
        BankModel bank = new BankModel();
        bank.setName(request.getBank().getName());
        bank.setAddress(request.getBank().getAddress());
        bank.setPhone(request.getBank().getPhone());
        bank.setWorkingHours(request.getBank().getWorkingHours());
        bank.setUser(savedUser);
        bank.setStatus(Status.UNDER_REVIEW);
        bank.setScore(0);
        bankRepository.save(bank);
    }

    private void createVeterinarian(RegisterDTO request, UserModel savedUser) {
        if (request.getRole() != Role.VETERINARIAN) return;
        VeterinarianModel veterinarian = new VeterinarianModel();
        veterinarian.setLicense(request.getVeterinarian().getLicense());
        veterinarian.setFileLicense(request.getVeterinarian().getFileLicense());
        veterinarian.setUser(savedUser);
        veterinarian.setStatus(Status.UNDER_REVIEW);
        veterinarian.setScore(0);
        veterinarianRepository.save(veterinarian);
    }

}
