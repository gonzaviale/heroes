package com.api.heroes.services;

import com.api.heroes.models.PetModel;
import com.api.heroes.models.enumerators.Status;
import com.api.heroes.models.enumerators.TypeOfPet;
import com.api.heroes.repositories.IPetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest {

    @Mock
    private IPetRepository repository;

    @InjectMocks
    private PetService petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        PetModel pet1 = new PetModel();
        pet1.setType(TypeOfPet.DOG);
        pet1.setName("Pet1");
        pet1.setStatus(Status.UNDER_REVIEW);
        PetModel pet2 = new PetModel();
        pet2.setType(TypeOfPet.CAT);
        pet2.setName("Pet2");
        pet2.setStatus(Status.UNDER_REVIEW);
        when(repository.findAll()).thenReturn(Arrays.asList(pet1, pet2));

        // Act
        List<PetModel> pets = petService.getAll();

        // Assert
        assertNotNull(pets);
        assertEquals(2, pets.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        PetModel pet = new PetModel();
        pet.setType(TypeOfPet.DOG);
        pet.setName("Pet1");
        pet.setStatus(Status.UNDER_REVIEW);
        when(repository.findById(1L)).thenReturn(Optional.of(pet));

        // Act
        Optional<PetModel> result = petService.getById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Pet1", result.get().getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        // Arrange
        PetModel pet = new PetModel();
        pet.setType(TypeOfPet.DOG);
        pet.setName("Pet1");
        pet.setStatus(Status.UNDER_REVIEW);
        PetModel savedPet = new PetModel();
        savedPet.setId(1L);
        savedPet.setType(TypeOfPet.DOG);
        savedPet.setName("Pet1");
        savedPet.setStatus(Status.UNDER_REVIEW);
        when(repository.save(pet)).thenReturn(savedPet);

        // Act
        PetModel result = petService.create(pet);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(repository, times(1)).save(pet);
    }

    @Test
    void testDelete() {
        // Arrange
        Long id = 1L;

        // Act
        petService.delete(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void testUpdate() {
        // Arrange
        PetModel updatedPet = new PetModel();
        updatedPet.setId(1L);
        updatedPet.setStatus(Status.UNDER_REVIEW);
        updatedPet.setType(TypeOfPet.DOG);
        updatedPet.setName("UpdatedPet");
        when(repository.save(updatedPet)).thenReturn(updatedPet);

        // Act
        PetModel result = petService.update(1L, updatedPet);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("UpdatedPet", result.getName());
        verify(repository, times(1)).save(updatedPet);
    }
}

