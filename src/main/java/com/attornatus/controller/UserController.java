package com.attornatus.controller;


import com.attornatus.entities.Users;
import com.attornatus.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping()
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> search(@PathVariable Integer id) {
        Users user = userService.search(id).orElse(null);
        return ResponseEntity.ok(user);
    }

    @PutMapping()
    public ResponseEntity<Users> update(@RequestBody Users user) {
        ResponseEntity<Users> response = null;

        if (user.getId() != null && userService.search(user.getId()).isPresent()) {
            response = ResponseEntity.ok(userService.update(user));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if(userService.search(id).isPresent()) {
            userService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("User Deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {

        return ResponseEntity.ok(userService.getAll());
    }

}
