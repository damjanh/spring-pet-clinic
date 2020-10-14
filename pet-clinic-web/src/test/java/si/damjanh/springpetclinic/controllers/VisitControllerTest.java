package si.damjanh.springpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import si.damjanh.springpetclinic.model.Pet;
import si.damjanh.springpetclinic.model.Visit;
import si.damjanh.springpetclinic.services.PetService;
import si.damjanh.springpetclinic.services.VisitService;

import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

    @Mock
    PetService petService;

    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(visitController)
                .build();
    }

    @Test
    void initNewVisitForm() throws Exception {
        Pet pet = new Pet();
        pet.setId(1L);
        when(petService.findById(anyLong())).thenReturn(pet);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        Pet pet = new Pet();
        pet.setId(1L);
        when(petService.findById(anyLong())).thenReturn(pet);
        mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/pets/1/visits/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("visit"));

        verify(visitService, times(1)).save(any(Visit.class));
    }
}
