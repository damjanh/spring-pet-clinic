package si.damjanh.springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.mockito.junit.jupiter.MockitoExtension;
import si.damjanh.springpetclinic.model.Owner;
import si.damjanh.springpetclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    static final String OWNER_LAST_NAME = "Smith";
    static final Long OWNER_ID = 1L;

    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(OWNER_ID).lastName(OWNER_LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = service.findByLastName(OWNER_LAST_NAME);


        assertEquals(OWNER_LAST_NAME, owner.getLastName());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).lastName("Jones").build());
        returnOwnerSet.add(Owner.builder().id(2L).lastName("Max").build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(OWNER_ID);

        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(OWNER_ID);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(eq(returnOwner));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository, times(1)).deleteById(eq(1L));
    }
}