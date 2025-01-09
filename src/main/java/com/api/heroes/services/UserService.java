package com.api.heroes.services;

import com.api.heroes.models.DTO.UserDTO;
import com.api.heroes.models.UserModel;
import com.api.heroes.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Convierte un UserModel en un UserDTO para evitar exponer información sensible.
     */
    public UserDTO convertToDTO(UserModel user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getUsername());
    }

    /**
     * Obtiene todos los usuarios.
     */
    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    /**
     * Guarda un usuario con la contraseña cifrada.
     */
    public UserModel saveUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Cifra la contraseña antes de guardar
        return userRepository.save(user);
    }

    /**
     * Obtiene un usuario por su ID.
     */
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un usuario por su ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Actualiza un usuario.
     * Si incluye una nueva contraseña, esta se cifra antes de guardar.
     */
    public UserModel updateUser(UserModel user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword())); // Cifra la nueva contraseña
        }
        return userRepository.save(user);
    }

    /**
     * Autentica a un usuario verificando su nombre de usuario y contraseña.
     */
    public UserModel authenticate(String username, String password) {
        Optional<UserModel> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();

            // Verificar si la contraseña proporcionada coincide con la almacenada
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user; // Autenticación exitosa
            }
        }

        return null; // Credenciales inválidas
    }
}
