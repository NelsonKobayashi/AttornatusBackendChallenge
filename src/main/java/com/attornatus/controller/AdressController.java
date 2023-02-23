package com.attornatus.controller;

import com.attornatus.entities.Adress;
import com.attornatus.service.AdressService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @PostMapping()
    public ResponseEntity<Adress> save(@RequestBody Adress adress) {
        return ResponseEntity.ok(adressService.save(adress));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adress> search(@PathVariable Integer id) {
        Adress adress = adressService.search(id).orElse(null);
        return ResponseEntity.ok(adress);
    }

    @PutMapping()
    public ResponseEntity<Adress> update(@RequestBody Adress adress) {
        ResponseEntity<Adress> response = null;

        if (adress.getId() != null && adressService.search(adress.getId()).isPresent()){
            response = ResponseEntity.ok(adressService.update(adress));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (adressService.search(id).isPresent()) {
            adressService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Adress deleted.");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Adress>> getAll(){
        return ResponseEntity.ok(adressService.getAll());
    }
}
