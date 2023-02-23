package com.attornatus.service;

import com.attornatus.entities.Users;
import com.attornatus.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    final static Logger log = Logger.getLogger(UserService.class);

    public Users save(Users user) {
        log.debug("Registering a new user" + user.toString());
        return iUserRepository.save(user);
    }

    public void delete(Integer id) {
        log.debug("Excluding user with ID: " + id);
        iUserRepository.deleteById(id);
    }

    public Optional<Users> search(Integer id) {
        log.debug("Searching user with ID: " + id);
        return iUserRepository.findById(id);
    }

    public List<Users> getAll() {
        log.debug("Searching all users.");
        return iUserRepository.findAll();
    }

    public Users update(Users user) {
        log.debug("Updating user: " + user.toString());
        return iUserRepository.save(user);
    }

}
