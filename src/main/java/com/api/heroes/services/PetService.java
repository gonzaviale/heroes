package com.api.heroes.services;

import com.api.heroes.models.DTO.UserDTO;
import com.api.heroes.models.PetModel;
import com.api.heroes.models.UserModel;
import com.api.heroes.repositories.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private IPetRepository repository;

    public List<PetModel> getAll() {
        List<PetModel> pets = repository.findAll();
        for (PetModel pet : pets) {
            UserDTO user = convertToDTO(pet.getOwner());
            pet.setOwner(convertToUser(user));
        }
        return pets;
    }

    public Optional<PetModel> getById(Long id) {
        Optional<PetModel> pet = repository.findById(id);
        if (pet.isPresent()) {
            UserDTO user = convertToDTO(pet.get().getOwner());
            pet.get().setOwner(convertToUser(user));
        }
        return pet;
    }

    public PetModel create(PetModel entity) {
        //        UserDTO user = convertToDTO(pet.getOwner());
//        pet.setOwner(convertToUser(user));
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PetModel update(Long id, PetModel entity) {
        entity.setId(id);
        PetModel pet = repository.save(entity);
        UserDTO user = convertToDTO(pet.getOwner());
        pet.setOwner(convertToUser(user));
        return pet;
    }

    private UserDTO convertToDTO(UserModel user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getUsername());
    }

    private UserModel convertToUser(UserDTO user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setUsername(user.getUsername());
        return userModel;
    }
}
