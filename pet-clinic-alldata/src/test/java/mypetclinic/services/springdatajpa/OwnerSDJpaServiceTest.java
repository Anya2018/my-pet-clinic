package mypetclinic.services.springdatajpa;

import mypetclinic.model.Owner;
import mypetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName("smith").build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, returnOwnersSet.size());


    }

    @Test
    void findbyId() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findbyId(1L);
        assertNotNull(owner);
    }

    @Test
    void findbyIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findbyId(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        //Optional:
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());

    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName("smith");
        assertEquals("smith", smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}
