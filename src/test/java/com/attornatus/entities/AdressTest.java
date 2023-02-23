package com.attornatus.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class AdressTest {

    private Adress adress;

    @Test
    @DisplayName("Adress data entry test")
    void adressEntryDataTest(){
        Adress adress = Adress.builder()
                .id(1)
                .adress("rua ali")
                .zipcode("12345678")
                .number("123")
                .city("sao paulo")
                .principalAdress(true)
                .build();

        assertEquals(1, adress.getId());
        assertEquals("rua ali", adress.getAdress());
        assertEquals( "12345678", adress.getZipcode());
        assertEquals( "123", adress.getNumber());
        assertEquals( "sao paulo", adress.getCity());
        assertEquals( true, adress.isPrincipalAdress());

    }
}