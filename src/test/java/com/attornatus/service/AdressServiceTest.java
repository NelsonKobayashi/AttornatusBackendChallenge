package com.attornatus.service;

import com.attornatus.entities.Adress;
import com.attornatus.repository.IAdressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@WebAppConfiguration
class AdressServiceTest {

    @InjectMocks
    private AdressService adressService;

    @Mock
    private IAdressRepository adressRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save Adress Test")
    void saveTest(){
        Adress adress = Adress.builder()
                .id(15)
                .adress("rua ali")
                .zipcode("12345678")
                .number("123")
                .city("sao paulo")
                .principalAdress(true)
                .build();

        adressService.save(adress);

        when(adressRepository.findById(15)).thenReturn(Optional.empty());
    }

    @Test
    @DisplayName("Get Adress By Id Test")
    void searchTest(){
        Optional<Adress> adress = adressService.search(1);

        assertNotNull(adress);
    }

    @Test
    @DisplayName("Get All Adress Test")
    void getAllTest(){
        List<Adress> adresses = adressService.getAll();

        assertNotNull(adresses);
    }

    @Test
    @DisplayName("Update Adress Test")
    void updateTest(){
        Adress adress = Adress.builder()
                .id(15)
                .adress("rua ali")
                .zipcode("12345678")
                .number("123")
                .city("sao paulo")
                .principalAdress(true)
                .build();

        adressService.save(adress);
        when(adressRepository.findById(15)).thenReturn(Optional.of(adress));

        adress.setAdress("rua acola");
        adressService.update(adress);

        Optional<Adress> updatedAdress = adressService.search(15);
        Assertions.assertTrue(updatedAdress.isPresent(), "O endereço foi atualizado com sucesso");
    }

    @Test
    @DisplayName("Delete Adress Test")
    void deleteTest() {
        adressService.delete(3);
        Optional<Adress> adress = adressRepository.findById(3);
        assertFalse(adress.isPresent(), "Endereço deletado com sucesso");
    }
}
