package com.attornatus.entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class UserTest {

    @Test
    @DisplayName("User data entry test")
    void userEntryDataTest(){
        Users user = Users.builder()
                .id(1)
                .name("nelson")
                .birth("06-11-1980")
                .build();

        assertEquals(1, user.getId());
        assertEquals("nelson", user.getName());
        assertEquals("06-11-1980", user.getBirth());


    }

}
