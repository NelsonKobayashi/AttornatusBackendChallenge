package com.attornatus.service;

import java.util.List;
import java.util.Optional;

import com.attornatus.entities.Users;
import com.attornatus.repository.IUserRepository;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@WebAppConfiguration
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save User Test")
    void saveTest() {
        Users user = Users.builder()
                .id(15)
                .name("nelson")
                .birth("06-11-1980")
                .build();
        userService.save(user);

        when(userRepository.findById(15)).thenReturn(Optional.of(user));

        Optional<Users> getUser = userService.search(15);
        assertTrue(getUser.isPresent());
        assertEquals("nelson", getUser.get().getName(), "O usuário salvo não foi encontrado corretamente.");
    }

    @Test
    @DisplayName("Get User By Id Test")
    void searchTest() {
        when(userRepository.findById(15)).thenReturn(Optional.empty());
        Optional<Users> user = userService.search(15);
        assertFalse(user.isPresent(), "O usuário não deveria ter sido encontrado.");
    }

    @Test
    @DisplayName("Get All Users Test")
    void getAllTest() {
        List<Users> users = List.of(
                Users.builder().id(1).name("Ana").birth("01-01-1990").build(),
                Users.builder().id(2).name("Carlos").birth("02-02-1991").build(),
                Users.builder().id(3).name("Maria").birth("03-03-1992").build()
        );

        when(userRepository.findAll()).thenReturn(users);

        List<Users> allUsers = userService.getAll();
        assertEquals(3, allUsers.size(), "A lista de usuários retornada está com tamanho incorreto.");

        for (Users user : allUsers) {
            assertTrue(users.contains(user), "A lista de usuários retornada não contém todos os usuários esperados.");
        }
    }

    @Test
    @DisplayName("Update User Test")
    void updateTest() {
        Users user = Users.builder()
                .id(15)
                .name("nelson")
                .birth("06-11-1980")
                .build();
        userService.save(user);

        when(userRepository.findById(15)).thenReturn(Optional.of(user));

        user.setName("Joãozinho");
        userService.update(user);

        Optional<Users> updatedUser = userService.search(15);
        assertTrue(updatedUser.isPresent(), "O usuário não foi encontrado após a atualização.");
        assertEquals("Joãozinho", updatedUser.get().getName(), "O nome do usuário foi atualizado corretamente.");
    }

    @Test
    @DisplayName("Delete User Test")
    void deleteTest() {
        userService.delete(15);

        when(userRepository.findById(15)).thenReturn(Optional.empty());
        Optional<Users> optUser = userService.search(15);
        assertFalse(optUser.isPresent(), "O usuário deletado com sucesso.");
    }
}
